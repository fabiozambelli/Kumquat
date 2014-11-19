package biz.fz5.app.kumquat.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.PortletRequest;

public class ContactInfoSearchTerms extends ContactInfoDisplayTerms {

	public ContactInfoSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		emailAddress = DAOParamUtil.getString(portletRequest, EMAIL_ADDRESS);		
		lastName = DAOParamUtil.getString(portletRequest, LAST_NAME);
		contactGroupId = DAOParamUtil.getLong(portletRequest, CONTACT_GROUP_ID);
	}

}
