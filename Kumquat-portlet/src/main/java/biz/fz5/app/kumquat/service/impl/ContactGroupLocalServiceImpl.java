package biz.fz5.app.kumquat.service.impl;

import biz.fz5.app.kumquat.model.ContactGroup;
import biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil;
import biz.fz5.app.kumquat.service.base.ContactGroupLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the contact group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link biz.fz5.app.kumquat.service.ContactGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see biz.fz5.app.kumquat.service.base.ContactGroupLocalServiceBaseImpl
 * @see biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil
 */
public class ContactGroupLocalServiceImpl
    extends ContactGroupLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil} to access the contact group local service.
     */
	
	/**
	 * Retrieve a contact group list
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<ContactGroup> list (long groupId, long companyId) throws SystemException, PortalException {
		
		List<ContactGroup> list = null;
		
		list = contactGroupPersistence.findByAll(companyId, groupId);
		
		return list;
	}
	
	/**
	 * Create a new contact group
	 * @param name
	 * @param description
	 * @param groupId
	 * @param companyId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public ContactGroup add (String name, String description, long groupId, long companyId) throws SystemException, PortalException {
		
		long contactGroupId = counterLocalService.increment(ContactGroup.class.getName());
		
		ContactGroup contactGroup = ContactGroupLocalServiceUtil.createContactGroup(contactGroupId);
		
		contactGroup.setName(name);
		contactGroup.setDescription(description);
		contactGroup.setCompanyId(companyId);
		contactGroup.setGroupId(groupId);	
		
		contactGroupPersistence.update(contactGroup);
				
		return contactGroup;
	}
	
	/**
	 * Remove a contact group
	 * @param contactGroupId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void remove (long contactGroupId) throws SystemException, PortalException {
		
		contactGroupPersistence.remove(contactGroupId);
	}
}
