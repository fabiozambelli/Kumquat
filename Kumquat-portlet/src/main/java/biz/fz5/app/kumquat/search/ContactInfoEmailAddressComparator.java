package biz.fz5.app.kumquat.search;

import biz.fz5.app.kumquat.model.ContactInfo;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ContactInfoEmailAddressComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4579250515640707648L;
	
	public static final String ORDER_BY_ASC = "emailAddress ASC";

	public static final String ORDER_BY_DESC = "emailAddress DESC";
		
	public static final String[] ORDER_BY_FIELDS = {
		"emailAddress"
	};
	
	public ContactInfoEmailAddressComparator() {
		this(false);
	}

	public ContactInfoEmailAddressComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		ContactInfo contactInfo1 = (ContactInfo)obj1;
		ContactInfo contactInfo2 = (ContactInfo)obj2;
		
		int value = contactInfo1.getEmailAddress().compareTo(contactInfo2.getEmailAddress());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	private boolean _ascending;
	
	@Override
	public boolean isAscending() {
		return _ascending;
	}
	
	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}
}
