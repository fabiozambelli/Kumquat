package biz.fz5.app.kumquat.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ContactInfo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfoLocalServiceUtil
 * @see biz.fz5.app.kumquat.service.base.ContactInfoLocalServiceBaseImpl
 * @see biz.fz5.app.kumquat.service.impl.ContactInfoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ContactInfoLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContactInfoLocalServiceUtil} to access the contact info local service. Add custom service methods to {@link biz.fz5.app.kumquat.service.impl.ContactInfoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the contact info to the database. Also notifies the appropriate model listeners.
    *
    * @param contactInfo the contact info
    * @return the contact info that was added
    * @throws SystemException if a system exception occurred
    */
    public biz.fz5.app.kumquat.model.ContactInfo addContactInfo(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new contact info with the primary key. Does not add the contact info to the database.
    *
    * @param contactInfoId the primary key for the new contact info
    * @return the new contact info
    */
    public biz.fz5.app.kumquat.model.ContactInfo createContactInfo(
        long contactInfoId);

    /**
    * Deletes the contact info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactInfoId the primary key of the contact info
    * @return the contact info that was removed
    * @throws PortalException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public biz.fz5.app.kumquat.model.ContactInfo deleteContactInfo(
        long contactInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the contact info from the database. Also notifies the appropriate model listeners.
    *
    * @param contactInfo the contact info
    * @return the contact info that was removed
    * @throws SystemException if a system exception occurred
    */
    public biz.fz5.app.kumquat.model.ContactInfo deleteContactInfo(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public biz.fz5.app.kumquat.model.ContactInfo fetchContactInfo(
        long contactInfoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contact info with the primary key.
    *
    * @param contactInfoId the primary key of the contact info
    * @return the contact info
    * @throws PortalException if a contact info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public biz.fz5.app.kumquat.model.ContactInfo getContactInfo(
        long contactInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<biz.fz5.app.kumquat.model.ContactInfo> getContactInfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contact infos.
    *
    * @return the number of contact infos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getContactInfosCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the contact info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contactInfo the contact info
    * @return the contact info that was updated
    * @throws SystemException if a system exception occurred
    */
    public biz.fz5.app.kumquat.model.ContactInfo updateContactInfo(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

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
    public biz.fz5.app.kumquat.model.ContactInfo add(
        java.lang.String firstName, java.lang.String lastName,
        java.lang.String emailAddress, java.lang.String telephoneNumber,
        boolean agreedToPrivacy, long contactGroupId, long groupId,
        long companyId, long userId, java.lang.String userName,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<biz.fz5.app.kumquat.model.ContactInfo> list(
        long contactGroupId, long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public boolean exist(long contactGroupId, java.lang.String emailAddress,
        long groupId, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<biz.fz5.app.kumquat.model.ContactInfo> search(
        long companyId, long groupId, java.lang.String lastName,
        java.lang.String emailAddress, boolean isAndOperator,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.util.OrderByComparator getContactInfoOrderByComparator(
        java.lang.String orderByCol, java.lang.String orderByType);
}
