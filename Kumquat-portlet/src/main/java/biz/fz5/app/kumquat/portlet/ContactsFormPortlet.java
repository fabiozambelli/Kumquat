package biz.fz5.app.kumquat.portlet;

import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.model.impl.ContactInfoImpl;
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
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 * Portlet implementation class ContactsFormPortlet
 */
public class ContactsFormPortlet extends MVCPortlet {
 
	private static final Log _log = LogFactoryUtil.getLog(ContactsFormPortlet.class);
	
	/**
	 * Add a new contact
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void processAdd(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String telephoneNumber = ParamUtil.getString(actionRequest, "telephoneNumber");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		boolean agreedToPrivacy = ParamUtil.getBoolean(actionRequest, "agreedToPrivacy");
		
		_log.debug("firstName:"+firstName);
		_log.debug("lastName:"+lastName);
		_log.debug("telephoneNumber:"+telephoneNumber);
		_log.debug("emailAddress:"+emailAddress);
		_log.debug("agreedToPrivacy:"+agreedToPrivacy);
	
		long contactGroupId = ParamUtil.getLong(actionRequest, "contactGroupId");
		_log.debug("contactGroupId:"+contactGroupId);
		
		// store in request the user fields definition		
		ContactInfo cntct= new ContactInfoImpl();		
		cntct.setFirstName(firstName);
		cntct.setLastName(lastName);
		cntct.setEmailAddress(emailAddress);
		cntct.setTelephoneNumber(telephoneNumber);
		cntct.setAgreedToPrivacy(agreedToPrivacy);
		actionRequest.setAttribute("contact",cntct);
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (isValidationPassed(actionRequest)) {

			try {

				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(actionRequest);

				if (!ContactInfoLocalServiceUtil.exist(contactGroupId, emailAddress, themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId())) {
				
					ContactInfoLocalServiceUtil.add(firstName, lastName, emailAddress, telephoneNumber, agreedToPrivacy, contactGroupId, 
							themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), themeDisplay.getUserId(), themeDisplay.getUser().getScreenName(), 
							serviceContext);
					
					SessionMessages.add(actionRequest, "contact-saved-successfully");					
					
				} else {
					
					
					SessionMessages.add(actionRequest, (String)actionRequest.getAttribute(WebKeys.PORTLET_ID) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					
					SessionErrors.add(actionRequest, "contact-already-exists");
				}				
				
			} catch (SystemException e) {
				
				_log.error("SystemException:"+e);
				
				e.printStackTrace();
				
			} catch (PortalException e) {
				
				_log.error("PortalException:"+e);
				
				e.printStackTrace();
			}

		} else {
			
			SessionMessages.add(actionRequest, (String)actionRequest.getAttribute(WebKeys.PORTLET_ID) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			SessionErrors.add(actionRequest, "fields-required");
		}

	}
	
	/**
	 * Perform validation
	 * @param actionRequest
	 * @return
	 */
	private boolean isValidationPassed(ActionRequest actionRequest){
		
		long contactGroupId = ParamUtil.getLong(actionRequest, "contactGroupId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String telephoneNumber = ParamUtil.getString(actionRequest, "telephoneNumber");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		boolean agreedToPrivacy = ParamUtil.getBoolean(actionRequest, "agreedToPrivacy");	
		
		boolean isValid = true;
		if ( (!Validator.isNotNull(contactGroupId))||(contactGroupId==-1) ) {
			isValid = false;
			SessionErrors.add(actionRequest, "contact-group-id-error", "contact-group-id-undefined");
		} 
		if ( (!Validator.isNotNull(firstName))||("".equals(firstName)) ) {
			isValid = false;
			SessionErrors.add(actionRequest, "firstname-error", "firstname-undefined");
		} else if (!Validator.isName(firstName)) {
			isValid = false;
			SessionErrors.add(actionRequest, "firstname-error", "firstname-invalid");
		}		
		if (!Validator.isNotNull(lastName)) {
			isValid = false;
			SessionErrors.add(actionRequest, "lastname-error", "lastname-undefined");
		} else if (!Validator.isName(lastName)) {
			isValid = false;
			SessionErrors.add(actionRequest, "lastname-error", "lastname-invalid");
		}
		if (!Validator.isNotNull(emailAddress)) {
			isValid = false;
			SessionErrors.add(actionRequest, "email-error", "email-undefined");
		} else if (!Validator.isEmailAddress(emailAddress)) {
			isValid = false;
			SessionErrors.add(actionRequest, "email-error", "email-invalid");
		}
		if (!Validator.isNotNull(telephoneNumber)) {
			isValid = false;
			SessionErrors.add(actionRequest, "telephone-error", "phone-undefined");
		} else if (!Validator.isPhoneNumber(telephoneNumber)) {
			isValid = false;
			SessionErrors.add(actionRequest, "telephone-error", "phone-invalid");
		}
		if (!Validator.isNotNull(agreedToPrivacy)) {
			isValid = false;
			SessionErrors.add(actionRequest, "agreement-error", "agree-undefined");
		} else if (!agreedToPrivacy) {
			isValid = false;
			SessionErrors.add(actionRequest, "agreement-error", "agree-undefined");
		}
		
		
		return isValid;
	}

}
