package biz.fz5.app.kumquat.service.persistence;

import biz.fz5.app.kumquat.model.ContactInfo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contact info service. This utility wraps {@link ContactInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfoPersistence
 * @see ContactInfoPersistenceImpl
 * @generated
 */
public class ContactInfoUtil {
    private static ContactInfoPersistence _persistence;

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
    public static void clearCache(ContactInfo contactInfo) {
        getPersistence().clearCache(contactInfo);
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
    public static List<ContactInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ContactInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ContactInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ContactInfo update(ContactInfo contactInfo)
        throws SystemException {
        return getPersistence().update(contactInfo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ContactInfo update(ContactInfo contactInfo,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(contactInfo, serviceContext);
    }

    /**
    * Returns all the contact infos where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findByContactGroup(
        long contactGroupId, long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroup(contactGroupId, companyId, groupId);
    }

    /**
    * Returns a range of all the contact infos where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of contact infos
    * @param end the upper bound of the range of contact infos (not inclusive)
    * @return the range of matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findByContactGroup(
        long contactGroupId, long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroup(contactGroupId, companyId, groupId,
            start, end);
    }

    /**
    * Returns an ordered range of all the contact infos where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of contact infos
    * @param end the upper bound of the range of contact infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findByContactGroup(
        long contactGroupId, long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroup(contactGroupId, companyId, groupId,
            start, end, orderByComparator);
    }

    /**
    * Returns the first contact info in the ordered set where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact info
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo findByContactGroup_First(
        long contactGroupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroup_First(contactGroupId, companyId,
            groupId, orderByComparator);
    }

    /**
    * Returns the first contact info in the ordered set where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact info, or <code>null</code> if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo fetchByContactGroup_First(
        long contactGroupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactGroup_First(contactGroupId, companyId,
            groupId, orderByComparator);
    }

    /**
    * Returns the last contact info in the ordered set where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact info
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo findByContactGroup_Last(
        long contactGroupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroup_Last(contactGroupId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Returns the last contact info in the ordered set where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact info, or <code>null</code> if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo fetchByContactGroup_Last(
        long contactGroupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactGroup_Last(contactGroupId, companyId,
            groupId, orderByComparator);
    }

    /**
    * Returns the contact infos before and after the current contact info in the ordered set where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactInfoId the primary key of the current contact info
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact info
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo[] findByContactGroup_PrevAndNext(
        long contactInfoId, long contactGroupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroup_PrevAndNext(contactInfoId,
            contactGroupId, companyId, groupId, orderByComparator);
    }

    /**
    * Removes all the contact infos where contactGroupId = &#63; and companyId = &#63; and groupId = &#63; from the database.
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByContactGroup(long contactGroupId,
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByContactGroup(contactGroupId, companyId, groupId);
    }

    /**
    * Returns the number of contact infos where contactGroupId = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByContactGroup(long contactGroupId, long companyId,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByContactGroup(contactGroupId, companyId, groupId);
    }

    /**
    * Returns all the contact infos where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findByContactGroupEmail(
        long contactGroupId, java.lang.String emailAddress, long companyId,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroupEmail(contactGroupId, emailAddress,
            companyId, groupId);
    }

    /**
    * Returns a range of all the contact infos where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of contact infos
    * @param end the upper bound of the range of contact infos (not inclusive)
    * @return the range of matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findByContactGroupEmail(
        long contactGroupId, java.lang.String emailAddress, long companyId,
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroupEmail(contactGroupId, emailAddress,
            companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the contact infos where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of contact infos
    * @param end the upper bound of the range of contact infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findByContactGroupEmail(
        long contactGroupId, java.lang.String emailAddress, long companyId,
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroupEmail(contactGroupId, emailAddress,
            companyId, groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first contact info in the ordered set where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact info
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo findByContactGroupEmail_First(
        long contactGroupId, java.lang.String emailAddress, long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroupEmail_First(contactGroupId, emailAddress,
            companyId, groupId, orderByComparator);
    }

    /**
    * Returns the first contact info in the ordered set where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contact info, or <code>null</code> if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo fetchByContactGroupEmail_First(
        long contactGroupId, java.lang.String emailAddress, long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactGroupEmail_First(contactGroupId,
            emailAddress, companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last contact info in the ordered set where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact info
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo findByContactGroupEmail_Last(
        long contactGroupId, java.lang.String emailAddress, long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroupEmail_Last(contactGroupId, emailAddress,
            companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last contact info in the ordered set where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contact info, or <code>null</code> if a matching contact info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo fetchByContactGroupEmail_Last(
        long contactGroupId, java.lang.String emailAddress, long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByContactGroupEmail_Last(contactGroupId, emailAddress,
            companyId, groupId, orderByComparator);
    }

    /**
    * Returns the contact infos before and after the current contact info in the ordered set where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactInfoId the primary key of the current contact info
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contact info
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo[] findByContactGroupEmail_PrevAndNext(
        long contactInfoId, long contactGroupId, java.lang.String emailAddress,
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByContactGroupEmail_PrevAndNext(contactInfoId,
            contactGroupId, emailAddress, companyId, groupId, orderByComparator);
    }

    /**
    * Removes all the contact infos where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63; from the database.
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByContactGroupEmail(long contactGroupId,
        java.lang.String emailAddress, long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByContactGroupEmail(contactGroupId, emailAddress, companyId,
            groupId);
    }

    /**
    * Returns the number of contact infos where contactGroupId = &#63; and emailAddress = &#63; and companyId = &#63; and groupId = &#63;.
    *
    * @param contactGroupId the contact group ID
    * @param emailAddress the email address
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching contact infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByContactGroupEmail(long contactGroupId,
        java.lang.String emailAddress, long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByContactGroupEmail(contactGroupId, emailAddress,
            companyId, groupId);
    }

    /**
    * Caches the contact info in the entity cache if it is enabled.
    *
    * @param contactInfo the contact info
    */
    public static void cacheResult(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo) {
        getPersistence().cacheResult(contactInfo);
    }

    /**
    * Caches the contact infos in the entity cache if it is enabled.
    *
    * @param contactInfos the contact infos
    */
    public static void cacheResult(
        java.util.List<biz.fz5.app.kumquat.model.ContactInfo> contactInfos) {
        getPersistence().cacheResult(contactInfos);
    }

    /**
    * Creates a new contact info with the primary key. Does not add the contact info to the database.
    *
    * @param contactInfoId the primary key for the new contact info
    * @return the new contact info
    */
    public static biz.fz5.app.kumquat.model.ContactInfo create(
        long contactInfoId) {
        return getPersistence().create(contactInfoId);
    }

    /**
    * Removes the contact info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactInfoId the primary key of the contact info
    * @return the contact info that was removed
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo remove(
        long contactInfoId)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(contactInfoId);
    }

    public static biz.fz5.app.kumquat.model.ContactInfo updateImpl(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contactInfo);
    }

    /**
    * Returns the contact info with the primary key or throws a {@link biz.fz5.app.kumquat.NoSuchContactInfoException} if it could not be found.
    *
    * @param contactInfoId the primary key of the contact info
    * @return the contact info
    * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo findByPrimaryKey(
        long contactInfoId)
        throws biz.fz5.app.kumquat.NoSuchContactInfoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(contactInfoId);
    }

    /**
    * Returns the contact info with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactInfoId the primary key of the contact info
    * @return the contact info, or <code>null</code> if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static biz.fz5.app.kumquat.model.ContactInfo fetchByPrimaryKey(
        long contactInfoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(contactInfoId);
    }

    /**
    * Returns all the contact infos.
    *
    * @return the contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the contact infos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contact infos
    * @param end the upper bound of the range of contact infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contact infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<biz.fz5.app.kumquat.model.ContactInfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the contact infos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of contact infos.
    *
    * @return the number of contact infos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ContactInfoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContactInfoPersistence) PortletBeanLocatorUtil.locate(biz.fz5.app.kumquat.service.ClpSerializer.getServletContextName(),
                    ContactInfoPersistence.class.getName());

            ReferenceRegistry.registerReference(ContactInfoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ContactInfoPersistence persistence) {
    }
}
