package biz.fz5.app.kumquat.search;

import biz.fz5.app.kumquat.model.ContactInfo;

import com.liferay.portal.kernel.util.OrderByComparator;

public class ContactInfoLastNameComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -237877016325978586L;

	public static final String ORDER_BY_ASC = "name ASC";

	public static final String ORDER_BY_DESC = "name DESC";
		
	public static final String[] ORDER_BY_FIELDS = {
		"lastName"
	};
	
	public ContactInfoLastNameComparator() {
		this(false);
	}

	public ContactInfoLastNameComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		ContactInfo contactInfo1 = (ContactInfo)obj1;
		ContactInfo contactInfo2 = (ContactInfo)obj2;
		
		int value = contactInfo1.getLastName().compareTo(contactInfo2.getLastName());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	private boolean _ascending;
}
