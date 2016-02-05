package biz.fz5.app.kumquat.portlet;

import biz.fz5.app.kumquat.model.ContactGroup;
import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil;
import biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Portlet implementation class ContactsReportPortlet
 */
public class ContactsReportPortlet extends MVCPortlet {
 
	private static final Log _log = LogFactoryUtil.getLog(ContactsReportPortlet.class);

	/**
	 * Switch for the contact group
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void setGroup (ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		String contactGroupId = ParamUtil.getString(actionRequest, "contactGroupId");	
		if ( (contactGroupId!=null)&&(!"".equals(contactGroupId)) )
			actionRequest.setAttribute("contactGroupId", Long.parseLong(contactGroupId));
		
	}
	
	/**
	 * Export the contact info list
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void export(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		String rootFolderId = ParamUtil.getString(actionRequest,"rootFolderId");
		String contactGroupId = ParamUtil.getString(actionRequest,"contactGroupId");
		
		_log.debug("rootFolderId:"+rootFolderId);
		_log.debug("contactGroupId:"+contactGroupId);
				
		try {
			
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(actionRequest);

			List<ContactInfo> cnts = null;
			
			try {
				cnts = ContactInfoLocalServiceUtil
						.list(Long.parseLong(contactGroupId), themeDisplay.getSiteGroupIdOrLiveGroupId(),
								themeDisplay.getCompanyId());
			} catch(Exception e) {
				cnts = new ArrayList<ContactInfo>();
			}
			
			_log.debug("cnts:"+cnts);
			
			ContactGroup contactGroup = ContactGroupLocalServiceUtil.getContactGroup(Long.parseLong(contactGroupId));
			
			FileEntry fileEntry = null;
			if ((cnts!=null)&&(cnts.size()>0))				
				fileEntry = xls(cnts, "Report_"+System.currentTimeMillis()+".xlsx", contactGroup, Long.parseLong(rootFolderId), serviceContext);
			
			_log.debug("fileEntry:"+fileEntry);
			
			String reportURL = null;
			
			if (fileEntry!=null) {
				reportURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK);
				_log.debug("reportURL:"+reportURL);
				actionRequest.setAttribute("download-contact-info-report", reportURL);
			}
			
			actionRequest.setAttribute("contactGroupId", Long.parseLong(contactGroupId));
			
			
		} catch (PortalException e) {
			_log.error("PortalException :"+e);
			e.printStackTrace();
		} catch (SystemException e) {
			_log.error("SystemException :"+e);
			e.printStackTrace();
		}

	}

	/**
	 * Perform export in xls
	 * @param cnts
	 * @param xlsTitle
	 * @param contactGroup
	 * @param serviceContext
	 * @return
	 */
	private FileEntry xls(List<ContactInfo> cnts, String xlsTitle, ContactGroup contactGroup, long rootFolderId, ServiceContext serviceContext) {
		
		FileEntry fileEntry = null;

		XSSFWorkbook workbook = new XSSFWorkbook();
		String sheetName = null;
		sheetName = contactGroup.getName();
		
		java.util.ResourceBundle res = java.util.ResourceBundle.getBundle("content/Language");
		
		XSSFSheet sheet = workbook.createSheet(res.getString("xls-sheet-name") + " " + sheetName);

		Map<String, Object[]> data = new TreeMap<String, Object[]>();
				
		data.put("1", new Object[] {				
					res.getString("xls-column-date"), 
					res.getString("xls-column-lastname"), 
					res.getString("xls-column-firstname"), 
					res.getString("xls-column-email"), 
					res.getString("xls-column-phone") });
		
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy HH:mm");		 
		int counter = 2;
		for (ContactInfo cnt : cnts) {
			data.put(
					Integer.toString(counter),
					new Object[] { dateFormat.format(cnt.getCreateDate()), cnt.getLastName(), cnt.getFirstName(),
							cnt.getEmailAddress(), cnt.getTelephoneNumber() });
			counter++;
		}
		
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			workbook.write(out);			
			out.close();
			
			int size = out.size();
			ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray());

			
			fileEntry = DLAppServiceUtil.addFileEntry(
			contactGroup.getGroupId(), rootFolderId, xlsTitle, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
			xlsTitle, "", "", is, size, serviceContext);			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileEntry;
	}
	
	
	/**
	 * 
	 * Remove contact info item
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void processRemove (ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortletException {
			
			String primKey = ParamUtil.getString(actionRequest, "primKey");
			
			if (Validator.isNotNull(primKey) && Validator.isNumber(primKey)) {
				
				try {
					ContactInfoLocalServiceUtil.remove(Long.parseLong(primKey));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

}
