package biz.fz5.app.kumquat.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil;
import biz.fz5.app.kumquat.service.base.ContactInfoLocalServiceBaseImpl;

/**
 * The implementation of the contact info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link biz.fz5.app.kumquat.service.ContactInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see biz.fz5.app.kumquat.service.base.ContactInfoLocalServiceBaseImpl
 * @see biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil
 */
public class ContactInfoLocalServiceImpl extends ContactInfoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil} to access the contact info local service.
     */
	
	/**
	 * Create a new contactInfo
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param telephoneNumber
	 * @param agreedToPrivacy
	 * @param contactGroupId
	 * @param groupId
	 * @param companyId
	 * @param userId
	 * @param userName
	 * @param serviceContext
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public ContactInfo add (String firstName, String lastName, String emailAddress, String telephoneNumber, boolean agreedToPrivacy, long contactGroupId, 
			long groupId, long companyId, long userId, String userName, ServiceContext serviceContext) throws SystemException, PortalException {
		
		long contactInfoId = counterLocalService.increment(ContactInfo.class.getName());
		
		ContactInfo contactInfo = ContactInfoLocalServiceUtil.createContactInfo(contactInfoId);
		
		contactInfo.setFirstName(firstName);		
		contactInfo.setLastName(lastName);
		contactInfo.setEmailAddress(emailAddress);
		contactInfo.setTelephoneNumber(telephoneNumber);		
		contactInfo.setAgreedToPrivacy(agreedToPrivacy);
		contactInfo.setContactGroupId(contactGroupId);
		contactInfo.setCompanyId(companyId);
		contactInfo.setGroupId(groupId);
		contactInfo.setUserId(userId);
		contactInfo.setUserName(userName);
		contactInfo.setCreateDate(new Date());
		contactInfo.setModifiedDate(new Date());
				
		
		contactInfoPersistence.update(contactInfo, serviceContext);
				
		return contactInfo;
	}
	
	/**
	 * Retrieve a contactInfo list
	 * @param contactGroupId
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<ContactInfo> list (long contactGroupId, long groupId, long companyId) throws SystemException, PortalException {
		
		List<ContactInfo> list = null;
		
		list = contactInfoPersistence.findByContactGroup(contactGroupId, companyId, groupId);
		
		return list;
	}
	
	/**
	 * Check if a contact already exists
	 * @param contactGroupId
	 * @param emailAddress
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public boolean exist (long contactGroupId, String emailAddress, long groupId, long companyId) throws SystemException, PortalException {
		
		int count = contactInfoPersistence.countByContactGroupEmail(contactGroupId, emailAddress, companyId, groupId);
		
		return (count>0)?true:false;
		
	}
}
