package biz.fz5.app.kumquat.service.persistence;

import biz.fz5.app.kumquat.model.ContactGroup;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contact group service. This utility wraps {@link ContactGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactGroupPersistence
 * @see ContactGroupPersistenceImpl
 * @generated
 */
public class ContactGroupUtil {
    private static ContactGroupPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(ContactGroup contactGroup) {
        getPersistence().clearCache(contactGroup);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ContactGroup> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ContactGroup> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ContactGroup> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ContactGroup update(ContactGroup contactGroup)
        throws SystemException {
        return getPersistence().update(contactGroup);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ContactGroup update(ContactGroup contactGroup,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(contactGroup, serviceContext);
    }

    /**
    * Returns all the contact groups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching contact groups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> findByAll(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAll(companyId, groupId);
    }

    /**
    * Returns a range of all the contact groups where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of contact groups
    * @param end the upper bound of the range of contact groups (not inclusive)
    * @return the range of matching contact groups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> findByAll(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAll(companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the contact groups where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of contact groups
    * @param end the upper bound of the range of contact groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contact groups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> findByAll(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAll(companyId, groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first contact group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact group
    * @throws biz.fz5.app.kumquat.NoSuchContactGroupException if a matching contact group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup findByAll_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactGroupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAll_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the first contact group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact group, or <code>null</code> if a matching contact group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup fetchByAll_First(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAll_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last contact group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact group
    * @throws biz.fz5.app.kumquat.NoSuchContactGroupException if a matching contact group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup findByAll_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactGroupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAll_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last contact group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact group, or <code>null</code> if a matching contact group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup fetchByAll_Last(
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAll_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the contact groups before and after the current contact group in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the primary key of the current contact group
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact group
    * @throws biz.fz5.app.kumquat.NoSuchContactGroupException if a contact group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup[] findByAll_PrevAndNext(
        long contactGroupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactGroupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAll_PrevAndNext(contactGroupId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the contact groups where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAll(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAll(companyId, groupId);
    }

    /**
    * Returns the number of contact groups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching contact groups
    * @throws SystemException if a system exception occurred
    */
    public static int countByAll(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAll(companyId, groupId);
    }

    /**
    * Caches the contact group in the entity cache if it is enabled.
    *
    * @param contactGroup the contact group
    */
    public static void cacheResult(
        biz.fz5.app.kumquat.model.ContactGroup contactGroup) {
        getPersistence().cacheResult(contactGroup);
    }

    /**
    * Caches the contact groups in the entity cache if it is enabled.
    *
    * @param contactGroups the contact groups
    */
    public static void cacheResult(
        java.util.List<biz.fz5.app.kumquat.model.ContactGroup> contactGroups) {
        getPersistence().cacheResult(contactGroups);
    }

    /**
    * Creates a new contact group with the primary key. Does not add the contact group to the database.
    *
    * @param contactGroupId the primary key for the new contact group
    * @return the new contact group
    */
    public static biz.fz5.app.kumquat.model.ContactGroup create(
        long contactGroupId) {
        return getPersistence().create(contactGroupId);
    }

    /**
    * Removes the contact group with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactGroupId the primary key of the contact group
    * @return the contact group that was removed
    * @throws biz.fz5.app.kumquat.NoSuchContactGroupException if a contact group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup remove(
        long contactGroupId)
        throws biz.fz5.app.kumquat.NoSuchContactGroupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(contactGroupId);
    }

    public static biz.fz5.app.kumquat.model.ContactGroup updateImpl(
        biz.fz5.app.kumquat.model.ContactGroup contactGroup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contactGroup);
    }

    /**
    * Returns the contact group with the primary key or throws a {@link biz.fz5.app.kumquat.NoSuchContactGroupException} if it could not be found.
    *
    * @param contactGroupId the primary key of the contact group
    * @return the contact group
    * @throws biz.fz5.app.kumquat.NoSuchContactGroupException if a contact group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup findByPrimaryKey(
        long contactGroupId)
        throws biz.fz5.app.kumquat.NoSuchContactGroupException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(contactGroupId);
    }

    /**
    * Returns the contact group with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactGroupId the primary key of the contact group
    * @return the contact group, or <code>null</code> if a contact group with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactGroup fetchByPrimaryKey(
        long contactGroupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(contactGroupId);
    }

    /**
    * Returns all the contact groups.
    *
    * @return the contact groups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the contact groups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contact groups
    * @param end the upper bound of the range of contact groups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contact groups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactGroup> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the contact groups from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of contact groups.
    *
    * @return the number of contact groups
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ContactGroupPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContactGroupPersistence) PortletBeanLocatorUtil.locate(biz.fz5.app.kumquat.service.ClpSerializer.getServletContextName(),
                    ContactGroupPersistence.class.getName());

            ReferenceRegistry.registerReference(ContactGroupUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ContactGroupPersistence persistence) {
    }
}
