package biz.fz5.app.kumquat.search;

import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class ContactInfoSearch extends SearchContainer<ContactInfo> {

	public static final String EMPTY_RESULTS_MESSAGE = "no-users-were-found";
	public static List<String> headerNames = new ArrayList<String>();
	public static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("last-name");
		headerNames.add("email-address");
		orderableHeaders.put("last-name", "last-name");
		orderableHeaders.put("email-address", "email-address");
		
	}
	
	public ContactInfoSearch(PortletRequest portletRequest, String portletId, PortletURL iteratorURL) {
		this(portletRequest, portletId, DEFAULT_CUR_PARAM, iteratorURL);
	}

	public ContactInfoSearch(
		PortletRequest portletRequest, String portletId, String curParam,
		PortletURL iteratorURL) {
		
		super(
				portletRequest, new ContactInfoDisplayTerms(portletRequest),
				new ContactInfoSearchTerms(portletRequest), curParam, DEFAULT_DELTA,
				iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		ContactInfoDisplayTerms displayTerms = (ContactInfoDisplayTerms)getDisplayTerms();	
		
		iteratorURL.setParameter(
				ContactInfoDisplayTerms.EMAIL_ADDRESS, displayTerms.getEmailAddress());			
		iteratorURL.setParameter(
				ContactInfoDisplayTerms.LAST_NAME, displayTerms.getLastName());
			
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
						portletId, "contacts-info-order-by-col", orderByCol);
				preferences.setValue(
						portletId, "contacts-info-order-by-type",
					orderByType);
			}
			else {
				orderByCol = preferences.getValue(
						portletId, "contacts-info-order-by-col", "last-name");
				orderByType = preferences.getValue(
						portletId, "contacts-info-order-by-type", "asc");
			}
			
			OrderByComparator orderByComparator =
					ContactInfoLocalServiceUtil.getContactInfoOrderByComparator(
					orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(ContactInfoSearch.class);
}
