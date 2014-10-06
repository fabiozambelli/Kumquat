package biz.fz5.app.kumquat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ContactGroup. This utility wraps
 * {@link biz.fz5.app.kumquat.service.impl.ContactGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactGroupLocalService
 * @see biz.fz5.app.kumquat.service.base.ContactGroupLocalServiceBaseImpl
 * @see biz.fz5.app.kumquat.service.impl.ContactGroupLocalServiceImpl
 * @generated
 */
public class ContactGroupLocalServiceUtil {
    private static ContactGroupLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link biz.fz5.app.kumquat.service.impl.ContactGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the contact group to the database. Also notifies the appropriate model listeners.
    *
    * @param contactGroup the contact group
    * @return the contact group that was added
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup addContactGroup(
        biz.fz5.app.kumquat.model.ContactGroup contactGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addContactGroup(contactGroup);
    }

    /**
    * Creates a new contact group with the primary key. Does not add the contact group to the database.
    *
    * @param contactGroupId the primary key for the new contact group
    * @return the new contact group
    */
    public static biz.fz5.app.kumquat.model.ContactGroup createContactGroup(
        long contactGroupId) {
        return getService().createContactGroup(contactGroupId);
    }

    /**
    * Deletes the contact group with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactGroupId the primary key of the contact group
    * @return the contact group that was removed
    * @throws PortalException if a contact group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup deleteContactGroup(
        long contactGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContactGroup(contactGroupId);
    }

    /**
    * Deletes the contact group from the database. Also notifies the appropriate model listeners.
    *
    * @param contactGroup the contact group
    * @return the contact group that was removed
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup deleteContactGroup(
        biz.fz5.app.kumquat.model.ContactGroup contactGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContactGroup(contactGroup);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static biz.fz5.app.kumquat.model.ContactGroup fetchContactGroup(
        long contactGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContactGroup(contactGroupId);
    }

    /**
    * Returns the contact group with the primary key.
    *
    * @param contactGroupId the primary key of the contact group
    * @return the contact group
    * @throws PortalException if a contact group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup getContactGroup(
        long contactGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactGroup(contactGroupId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contact groups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contact groups
    * @param end the upper bound of the range of contact groups (not inclusive)
    * @return the range of contact groups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> getContactGroups(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactGroups(start, end);
    }

    /**
    * Returns the number of contact groups.
    *
    * @return the number of contact groups
    * @throws SystemException if a system exception occurred
    */
    public static int getContactGroupsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactGroupsCount();
    }

    /**
    * Updates the contact group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contactGroup the contact group
    * @return the contact group that was updated
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup updateContactGroup(
        biz.fz5.app.kumquat.model.ContactGroup contactGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContactGroup(contactGroup);
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
    * Retrieve a contact group list
    *
    * @param groupId
    * @param companyId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> list(
        long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().list(groupId, companyId);
    }

    /**
    * Create a new contact group
    *
    * @param name
    * @param description
    * @param groupId
    * @param companyId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static biz.fz5.app.kumquat.model.ContactGroup add(
        java.lang.String name, java.lang.String description, long groupId,
        long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().add(name, description, groupId, companyId);
    }

    /**
    * Remove a contact group
    *
    * @param contactGroupId
    * @throws SystemException
    * @throws PortalException
    */
    public static void remove(long contactGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().remove(contactGroupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ContactGroupLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ContactGroupLocalService.class.getName());

            if (invokableLocalService instanceof ContactGroupLocalService) {
                _service = (ContactGroupLocalService) invokableLocalService;
            } else {
                _service = new ContactGroupLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ContactGroupLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ContactGroupLocalService service) {
    }
}
