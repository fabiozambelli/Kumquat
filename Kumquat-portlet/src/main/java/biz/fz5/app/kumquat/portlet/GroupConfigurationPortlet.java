package biz.fz5.app.kumquat.portlet;

import biz.fz5.app.kumquat.model.ContactGroup;
import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil;
import biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 * Portlet implementation class GroupConfigurationPortlet
 */
public class GroupConfigurationPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil
			.getLog(GroupConfigurationPortlet.class);

	/**
	 * Create a contact group
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void processAdd(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {

			if (isValidationPassed(actionRequest)) {

				ContactGroupLocalServiceUtil.add(name, description,
						themeDisplay.getSiteGroupIdOrLiveGroupId(),
						themeDisplay.getCompanyId());

				SessionMessages.add(actionRequest,
						"contact-group-item-successfull");

			} else {

				SessionErrors.add(actionRequest, "fields-required");
				actionRequest.setAttribute("actionName", "processAdd");
				actionResponse.setRenderParameter("jspPage",
						"/admin/editContactGroup.jsp");
			}

		} catch (SystemException e) {
			_log.error("SystemException:" + e);
			e.printStackTrace();
		} catch (PortalException e) {
			_log.error("PortalException:" + e);
			e.printStackTrace();
		}

	}

	/**
	 * Modify a contact group
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void processModify(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String contactGroupId = ParamUtil.getString(actionRequest, "primKey");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		ContactGroup contactGroup = null;

		try {

			if (isValidationPassed(actionRequest)) {

				// do action
				contactGroup = ContactGroupLocalServiceUtil
						.getContactGroup(Long.parseLong(contactGroupId));
				contactGroup.setName(name);
				contactGroup.setDescription(description);
				ContactGroupLocalServiceUtil.updateContactGroup(contactGroup);

				SessionMessages.add(actionRequest,
						"contact-group-item-successfull");

			} else {

				SessionErrors.add(actionRequest, "fields-required");

				contactGroup = ContactGroupLocalServiceUtil
						.getContactGroup(Long.parseLong(contactGroupId));
				actionRequest.setAttribute("actionName", "processModify");
				actionRequest.setAttribute("contactGroup", contactGroup);
				actionResponse.setRenderParameter("jspPage",
						"/admin/editContactGroup.jsp");
			}
		} catch (SystemException e) {
			_log.error("SystemException:" + e);
			e.printStackTrace();
		} catch (NumberFormatException e) {
			_log.error("NumberFormatException:" + e);
			e.printStackTrace();
		} catch (PortalException e) {
			_log.error("PortalException:" + e);
			e.printStackTrace();
		}

	}

	/**
	 * Remove a contact group
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void processRemove(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String primKey = ParamUtil.getString(actionRequest, "primKey");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		List<ContactInfo> list = null;
		try {
			list = ContactInfoLocalServiceUtil.list(Long.parseLong(primKey),
					themeDisplay.getSiteGroupIdOrLiveGroupId(),
					themeDisplay.getCompanyId());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if ((list == null) || (list.size() == 0)) {

			if (Validator.isNotNull(primKey) && Validator.isNumber(primKey)) {

				try {
					ContactGroupLocalServiceUtil.deleteContactGroup(Long
							.parseLong(primKey));

					SessionMessages.add(actionRequest,
							"contact-group-item-successfull");

				} catch (NumberFormatException e) {
					_log.error("NumberFormatException:" + e);
					e.printStackTrace();
				} catch (PortalException e) {
					_log.error("PortalException:" + e);
					e.printStackTrace();
				} catch (SystemException e) {
					_log.error("SystemException:" + e);
					e.printStackTrace();
				}

			}

		} else {
			SessionErrors.add(actionRequest, "contact-exists-for-group-id");
		}

	}

	/**
	 * Load a contact group module for modify
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void prepareModify(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String primKey = ParamUtil.getString(actionRequest, "primKey");

		try {
			ContactGroup contactGroup = ContactGroupLocalServiceUtil
					.getContactGroup(Long.parseLong(primKey));
			actionRequest.setAttribute("actionName", "processModify");
			actionRequest.setAttribute("contactGroup", contactGroup);

		} catch (NumberFormatException e) {
			_log.error("NumberFormatException:" + e);
			e.printStackTrace();
		} catch (PortalException e) {
			_log.error("PortalException:" + e);
			e.printStackTrace();
		} catch (SystemException e) {
			_log.error("SystemException:" + e);
			e.printStackTrace();
		}

		actionResponse.setRenderParameter("jspPage",
				"/admin/editContactGroup.jsp");
	}

	/**
	 * Load a contact group module for insert
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void prepareAdd(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		actionRequest.setAttribute("actionName", "processAdd");
		actionResponse.setRenderParameter("jspPage",
				"/admin/editContactGroup.jsp");
	}

	private boolean isValidationPassed(ActionRequest actionRequest) {

		String name = ParamUtil.getString(actionRequest, "name");

		boolean isValid = true;

		if ((!Validator.isNotNull(name)) || ("".equals(name))) {
			isValid = false;
			SessionErrors.add(actionRequest, "groupname-error",
					"groupname-undefined");
		} else if (!Validator.isName(name)) {
			isValid = false;
			SessionErrors.add(actionRequest, "groupname-error",
					"groupname-invalid");
		}

		return isValid;
	}

}
