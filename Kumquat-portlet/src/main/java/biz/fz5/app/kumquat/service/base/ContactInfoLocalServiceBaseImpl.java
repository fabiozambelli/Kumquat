package biz.fz5.app.kumquat.service.base;

import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.service.ContactInfoLocalService;
import biz.fz5.app.kumquat.service.persistence.ContactGroupPersistence;
import biz.fz5.app.kumquat.service.persistence.ContactInfoPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the contact info local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link biz.fz5.app.kumquat.service.impl.ContactInfoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see biz.fz5.app.kumquat.service.impl.ContactInfoLocalServiceImpl
 * @see biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil
 * @generated
 */
public abstract class ContactInfoLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements ContactInfoLocalService,
        IdentifiableBean {
    @BeanReference(type = biz.fz5.app.kumquat.service.ContactGroupLocalService.class)
    protected biz.fz5.app.kumquat.service.ContactGroupLocalService contactGroupLocalService;
    @BeanReference(type = ContactGroupPersistence.class)
    protected ContactGroupPersistence contactGroupPersistence;
    @BeanReference(type = biz.fz5.app.kumquat.service.ContactInfoLocalService.class)
    protected biz.fz5.app.kumquat.service.ContactInfoLocalService contactInfoLocalService;
    @BeanReference(type = ContactInfoPersistence.class)
    protected ContactInfoPersistence contactInfoPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ContactInfoLocalServiceClpInvoker _clpInvoker = new ContactInfoLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil} to access the contact info local service.
     */

    /**
     * Adds the contact info to the database. Also notifies the appropriate model listeners.
     *
     * @param contactInfo the contact info
     * @return the contact info that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ContactInfo addContactInfo(ContactInfo contactInfo)
        throws SystemException {
        contactInfo.setNew(true);

        return contactInfoPersistence.update(contactInfo);
    }

    /**
     * Creates a new contact info with the primary key. Does not add the contact info to the database.
     *
     * @param contactInfoId the primary key for the new contact info
     * @return the new contact info
     */
    @Override
    public ContactInfo createContactInfo(long contactInfoId) {
        return contactInfoPersistence.create(contactInfoId);
    }

    /**
     * Deletes the contact info with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contactInfoId the primary key of the contact info
     * @return the contact info that was removed
     * @throws PortalException if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public ContactInfo deleteContactInfo(long contactInfoId)
        throws PortalException, SystemException {
        return contactInfoPersistence.remove(contactInfoId);
    }

    /**
     * Deletes the contact info from the database. Also notifies the appropriate model listeners.
     *
     * @param contactInfo the contact info
     * @return the contact info that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public ContactInfo deleteContactInfo(ContactInfo contactInfo)
        throws SystemException {
        return contactInfoPersistence.remove(contactInfo);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(ContactInfo.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return contactInfoPersistence.findWithDynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return contactInfoPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return contactInfoPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return contactInfoPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return contactInfoPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public ContactInfo fetchContactInfo(long contactInfoId)
        throws SystemException {
        return contactInfoPersistence.fetchByPrimaryKey(contactInfoId);
    }

    /**
     * Returns the contact info with the primary key.
     *
     * @param contactInfoId the primary key of the contact info
     * @return the contact info
     * @throws PortalException if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContactInfo getContactInfo(long contactInfoId)
        throws PortalException, SystemException {
        return contactInfoPersistence.findByPrimaryKey(contactInfoId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return contactInfoPersistence.findByPrimaryKey(primaryKeyObj);
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
    @Override
    public List<ContactInfo> getContactInfos(int start, int end)
        throws SystemException {
        return contactInfoPersistence.findAll(start, end);
    }

    /**
     * Returns the number of contact infos.
     *
     * @return the number of contact infos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getContactInfosCount() throws SystemException {
        return contactInfoPersistence.countAll();
    }

    /**
     * Updates the contact info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param contactInfo the contact info
     * @return the contact info that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ContactInfo updateContactInfo(ContactInfo contactInfo)
        throws SystemException {
        return contactInfoPersistence.update(contactInfo);
    }

    /**
     * Returns the contact group local service.
     *
     * @return the contact group local service
     */
    public biz.fz5.app.kumquat.service.ContactGroupLocalService getContactGroupLocalService() {
        return contactGroupLocalService;
    }

    /**
     * Sets the contact group local service.
     *
     * @param contactGroupLocalService the contact group local service
     */
    public void setContactGroupLocalService(
        biz.fz5.app.kumquat.service.ContactGroupLocalService contactGroupLocalService) {
        this.contactGroupLocalService = contactGroupLocalService;
    }

    /**
     * Returns the contact group persistence.
     *
     * @return the contact group persistence
     */
    public ContactGroupPersistence getContactGroupPersistence() {
        return contactGroupPersistence;
    }

    /**
     * Sets the contact group persistence.
     *
     * @param contactGroupPersistence the contact group persistence
     */
    public void setContactGroupPersistence(
        ContactGroupPersistence contactGroupPersistence) {
        this.contactGroupPersistence = contactGroupPersistence;
    }

    /**
     * Returns the contact info local service.
     *
     * @return the contact info local service
     */
    public biz.fz5.app.kumquat.service.ContactInfoLocalService getContactInfoLocalService() {
        return contactInfoLocalService;
    }

    /**
     * Sets the contact info local service.
     *
     * @param contactInfoLocalService the contact info local service
     */
    public void setContactInfoLocalService(
        biz.fz5.app.kumquat.service.ContactInfoLocalService contactInfoLocalService) {
        this.contactInfoLocalService = contactInfoLocalService;
    }

    /**
     * Returns the contact info persistence.
     *
     * @return the contact info persistence
     */
    public ContactInfoPersistence getContactInfoPersistence() {
        return contactInfoPersistence;
    }

    /**
     * Sets the contact info persistence.
     *
     * @param contactInfoPersistence the contact info persistence
     */
    public void setContactInfoPersistence(
        ContactInfoPersistence contactInfoPersistence) {
        this.contactInfoPersistence = contactInfoPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("biz.fz5.app.kumquat.model.ContactInfo",
            contactInfoLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "biz.fz5.app.kumquat.model.ContactInfo");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return ContactInfo.class;
    }

    protected String getModelClassName() {
        return ContactInfo.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = contactInfoPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
