package biz.fz5.app.kumquat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ContactInfo. This utility wraps
 * {@link biz.fz5.app.kumquat.service.impl.ContactInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfoLocalService
 * @see biz.fz5.app.kumquat.service.base.ContactInfoLocalServiceBaseImpl
 * @see biz.fz5.app.kumquat.service.impl.ContactInfoLocalServiceImpl
 * @generated
 */
public class ContactInfoLocalServiceUtil {
    private static ContactInfoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link biz.fz5.app.kumquat.service.impl.ContactInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the contact info to the database. Also notifies the appropriate model listeners.
    *
    * @param contactInfo the contact info
    * @return the contact info that was added
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo addContactInfo(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addContactInfo(contactInfo);
    }

    /**
    * Creates a new contact info with the primary key. Does not add the contact info to the database.
    *
    * @param contactInfoId the primary key for the new contact info
    * @return the new contact info
    */
    public static biz.fz5.app.kumquat.model.ContactInfo createContactInfo(
        long contactInfoId) {
        return getService().createContactInfo(contactInfoId);
    }

    /**
    * Deletes the contact info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactInfoId the primary key of the contact info
    * @return the contact info that was removed
    * @throws PortalException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo deleteContactInfo(
        long contactInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContactInfo(contactInfoId);
    }

    /**
    * Deletes the contact info from the database. Also notifies the appropriate model listeners.
    *
    * @param contactInfo the contact info
    * @return the contact info that was removed
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo deleteContactInfo(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContactInfo(contactInfo);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static biz.fz5.app.kumquat.model.ContactInfo fetchContactInfo(
        long contactInfoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContactInfo(contactInfoId);
    }

    /**
    * Returns the contact info with the primary key.
    *
    * @param contactInfoId the primary key of the contact info
    * @return the contact info
    * @throws PortalException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo getContactInfo(
        long contactInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactInfo(contactInfoId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contact infos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contact infos
    * @param end the upper bound of the range of contact infos (not inclusive)
    * @return the range of contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> getContactInfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactInfos(start, end);
    }

    /**
    * Returns the number of contact infos.
    *
    * @return the number of contact infos
    * @throws SystemException if a system exception occurred
    */
    public static int getContactInfosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactInfosCount();
    }

    /**
    * Updates the contact info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contactInfo the contact info
    * @return the contact info that was updated
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo updateContactInfo(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContactInfo(contactInfo);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Create a new contactInfo
    *
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
    public static biz.fz5.app.kumquat.model.ContactInfo add(
        java.lang.String firstName, java.lang.String lastName,
        java.lang.String emailAddress, java.lang.String telephoneNumber,
        boolean agreedToPrivacy, long contactGroupId, long groupId,
        long companyId, long userId, java.lang.String userName,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .add(firstName, lastName, emailAddress, telephoneNumber,
            agreedToPrivacy, contactGroupId, groupId, companyId, userId,
            userName, serviceContext);
    }

    /**
    * Retrieve a contactInfo list
    *
    * @param contactGroupId
    * @param groupId
    * @param companyId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> list(
        long contactGroupId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().list(contactGroupId, groupId, companyId);
    }

    /**
    * Check if a contact already exists
    *
    * @param contactGroupId
    * @param emailAddress
    * @param groupId
    * @param companyId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static boolean exist(long contactGroupId,
        java.lang.String emailAddress, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .exist(contactGroupId, emailAddress, groupId, companyId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ContactInfoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ContactInfoLocalService.class.getName());

            if (invokableLocalService instanceof ContactInfoLocalService) {
                _service = (ContactInfoLocalService) invokableLocalService;
            } else {
                _service = new ContactInfoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ContactInfoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ContactInfoLocalService service) {
    }
}
