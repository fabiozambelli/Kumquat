package biz.fz5.app.kumquat.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class ContactInfoDisplayTerms extends DisplayTerms {

	public static final String EMAIL_ADDRESS = "emailAddress";

	public static final String LAST_NAME = "lastName";
	
	public ContactInfoDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		emailAddress = ParamUtil.getString(portletRequest, EMAIL_ADDRESS);		
		lastName = ParamUtil.getString(portletRequest, LAST_NAME);
	}
	
	protected String emailAddress;
	
	protected String lastName;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}
