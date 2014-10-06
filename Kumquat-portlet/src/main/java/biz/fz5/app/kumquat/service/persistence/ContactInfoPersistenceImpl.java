package biz.fz5.app.kumquat.service.persistence;

import biz.fz5.app.kumquat.NoSuchContactInfoException;
import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.model.impl.ContactInfoImpl;
import biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl;
import biz.fz5.app.kumquat.service.persistence.ContactInfoPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contact info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfoPersistence
 * @see ContactInfoUtil
 * @generated
 */
public class ContactInfoPersistenceImpl extends BasePersistenceImpl<ContactInfo>
    implements ContactInfoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ContactInfoUtil} to access the contact info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ContactInfoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, ContactInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, ContactInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTGROUP =
        new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, ContactInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactGroup",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP =
        new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, ContactInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactGroup",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            },
            ContactInfoModelImpl.CONTACTGROUPID_COLUMN_BITMASK |
            ContactInfoModelImpl.COMPANYID_COLUMN_BITMASK |
            ContactInfoModelImpl.GROUPID_COLUMN_BITMASK |
            ContactInfoModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTGROUP = new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactGroup",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2 = "contactInfo.contactGroupId = ? AND ";
    private static final String _FINDER_COLUMN_CONTACTGROUP_COMPANYID_2 = "contactInfo.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CONTACTGROUP_GROUPID_2 = "contactInfo.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTGROUPEMAIL =
        new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, ContactInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactGroupEmail",
            new String[] {
                Long.class.getName(), String.class.getName(),
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUPEMAIL =
        new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, ContactInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByContactGroupEmail",
            new String[] {
                Long.class.getName(), String.class.getName(),
                Long.class.getName(), Long.class.getName()
            },
            ContactInfoModelImpl.CONTACTGROUPID_COLUMN_BITMASK |
            ContactInfoModelImpl.EMAILADDRESS_COLUMN_BITMASK |
            ContactInfoModelImpl.COMPANYID_COLUMN_BITMASK |
            ContactInfoModelImpl.GROUPID_COLUMN_BITMASK |
            ContactInfoModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTGROUPEMAIL = new FinderPath(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByContactGroupEmail",
            new String[] {
                Long.class.getName(), String.class.getName(),
                Long.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_CONTACTGROUPEMAIL_CONTACTGROUPID_2 =
        "contactInfo.contactGroupId = ? AND ";
    private static final String _FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_1 = "contactInfo.emailAddress IS NULL AND ";
    private static final String _FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_2 = "contactInfo.emailAddress = ? AND ";
    private static final String _FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_3 = "(contactInfo.emailAddress IS NULL OR contactInfo.emailAddress = '') AND ";
    private static final String _FINDER_COLUMN_CONTACTGROUPEMAIL_COMPANYID_2 = "contactInfo.companyId = ? AND ";
    private static final String _FINDER_COLUMN_CONTACTGROUPEMAIL_GROUPID_2 = "contactInfo.groupId = ?";
    private static final String _SQL_SELECT_CONTACTINFO = "SELECT contactInfo FROM ContactInfo contactInfo";
    private static final String _SQL_SELECT_CONTACTINFO_WHERE = "SELECT contactInfo FROM ContactInfo contactInfo WHERE ";
    private static final String _SQL_COUNT_CONTACTINFO = "SELECT COUNT(contactInfo) FROM ContactInfo contactInfo";
    private static final String _SQL_COUNT_CONTACTINFO_WHERE = "SELECT COUNT(contactInfo) FROM ContactInfo contactInfo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "contactInfo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactInfo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactInfo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ContactInfoPersistenceImpl.class);
    private static ContactInfo _nullContactInfo = new ContactInfoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ContactInfo> toCacheModel() {
                return _nullContactInfoCacheModel;
            }
        };

    private static CacheModel<ContactInfo> _nullContactInfoCacheModel = new CacheModel<ContactInfo>() {
            @Override
            public ContactInfo toEntityModel() {
                return _nullContactInfo;
            }
        };

    public ContactInfoPersistenceImpl() {
        setModelClass(ContactInfo.class);
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
    @Override
    public List<ContactInfo> findByContactGroup(long contactGroupId,
        long companyId, long groupId) throws SystemException {
        return findByContactGroup(contactGroupId, companyId, groupId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<ContactInfo> findByContactGroup(long contactGroupId,
        long companyId, long groupId, int start, int end)
        throws SystemException {
        return findByContactGroup(contactGroupId, companyId, groupId, start,
            end, null);
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
    @Override
    public List<ContactInfo> findByContactGroup(long contactGroupId,
        long companyId, long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP;
            finderArgs = new Object[] { contactGroupId, companyId, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTGROUP;
            finderArgs = new Object[] {
                    contactGroupId, companyId, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<ContactInfo> list = (List<ContactInfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ContactInfo contactInfo : list) {
                if ((contactGroupId != contactInfo.getContactGroupId()) ||
                        (companyId != contactInfo.getCompanyId()) ||
                        (groupId != contactInfo.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_CONTACTINFO_WHERE);

            query.append(_FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2);

            query.append(_FINDER_COLUMN_CONTACTGROUP_COMPANYID_2);

            query.append(_FINDER_COLUMN_CONTACTGROUP_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactInfoModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactGroupId);

                qPos.add(companyId);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<ContactInfo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ContactInfo>(list);
                } else {
                    list = (List<ContactInfo>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public ContactInfo findByContactGroup_First(long contactGroupId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchContactInfoException, SystemException {
        ContactInfo contactInfo = fetchByContactGroup_First(contactGroupId,
                companyId, groupId, orderByComparator);

        if (contactInfo != null) {
            return contactInfo;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactGroupId=");
        msg.append(contactGroupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactInfoException(msg.toString());
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
    @Override
    public ContactInfo fetchByContactGroup_First(long contactGroupId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        List<ContactInfo> list = findByContactGroup(contactGroupId, companyId,
                groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public ContactInfo findByContactGroup_Last(long contactGroupId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchContactInfoException, SystemException {
        ContactInfo contactInfo = fetchByContactGroup_Last(contactGroupId,
                companyId, groupId, orderByComparator);

        if (contactInfo != null) {
            return contactInfo;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactGroupId=");
        msg.append(contactGroupId);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactInfoException(msg.toString());
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
    @Override
    public ContactInfo fetchByContactGroup_Last(long contactGroupId,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByContactGroup(contactGroupId, companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<ContactInfo> list = findByContactGroup(contactGroupId, companyId,
                groupId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public ContactInfo[] findByContactGroup_PrevAndNext(long contactInfoId,
        long contactGroupId, long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchContactInfoException, SystemException {
        ContactInfo contactInfo = findByPrimaryKey(contactInfoId);

        Session session = null;

        try {
            session = openSession();

            ContactInfo[] array = new ContactInfoImpl[3];

            array[0] = getByContactGroup_PrevAndNext(session, contactInfo,
                    contactGroupId, companyId, groupId, orderByComparator, true);

            array[1] = contactInfo;

            array[2] = getByContactGroup_PrevAndNext(session, contactInfo,
                    contactGroupId, companyId, groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ContactInfo getByContactGroup_PrevAndNext(Session session,
        ContactInfo contactInfo, long contactGroupId, long companyId,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACTINFO_WHERE);

        query.append(_FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2);

        query.append(_FINDER_COLUMN_CONTACTGROUP_COMPANYID_2);

        query.append(_FINDER_COLUMN_CONTACTGROUP_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ContactInfoModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(contactGroupId);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contactInfo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ContactInfo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the contact infos where contactGroupId = &#63; and companyId = &#63; and groupId = &#63; from the database.
     *
     * @param contactGroupId the contact group ID
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByContactGroup(long contactGroupId, long companyId,
        long groupId) throws SystemException {
        for (ContactInfo contactInfo : findByContactGroup(contactGroupId,
                companyId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(contactInfo);
        }
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
    @Override
    public int countByContactGroup(long contactGroupId, long companyId,
        long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTGROUP;

        Object[] finderArgs = new Object[] { contactGroupId, companyId, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_CONTACTINFO_WHERE);

            query.append(_FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2);

            query.append(_FINDER_COLUMN_CONTACTGROUP_COMPANYID_2);

            query.append(_FINDER_COLUMN_CONTACTGROUP_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactGroupId);

                qPos.add(companyId);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public List<ContactInfo> findByContactGroupEmail(long contactGroupId,
        String emailAddress, long companyId, long groupId)
        throws SystemException {
        return findByContactGroupEmail(contactGroupId, emailAddress, companyId,
            groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<ContactInfo> findByContactGroupEmail(long contactGroupId,
        String emailAddress, long companyId, long groupId, int start, int end)
        throws SystemException {
        return findByContactGroupEmail(contactGroupId, emailAddress, companyId,
            groupId, start, end, null);
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
    @Override
    public List<ContactInfo> findByContactGroupEmail(long contactGroupId,
        String emailAddress, long companyId, long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUPEMAIL;
            finderArgs = new Object[] {
                    contactGroupId, emailAddress, companyId, groupId
                };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTGROUPEMAIL;
            finderArgs = new Object[] {
                    contactGroupId, emailAddress, companyId, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<ContactInfo> list = (List<ContactInfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ContactInfo contactInfo : list) {
                if ((contactGroupId != contactInfo.getContactGroupId()) ||
                        !Validator.equals(emailAddress,
                            contactInfo.getEmailAddress()) ||
                        (companyId != contactInfo.getCompanyId()) ||
                        (groupId != contactInfo.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(6 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(6);
            }

            query.append(_SQL_SELECT_CONTACTINFO_WHERE);

            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_CONTACTGROUPID_2);

            boolean bindEmailAddress = false;

            if (emailAddress == null) {
                query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_1);
            } else if (emailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_3);
            } else {
                bindEmailAddress = true;

                query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_2);
            }

            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_COMPANYID_2);

            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ContactInfoModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactGroupId);

                if (bindEmailAddress) {
                    qPos.add(emailAddress);
                }

                qPos.add(companyId);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<ContactInfo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ContactInfo>(list);
                } else {
                    list = (List<ContactInfo>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public ContactInfo findByContactGroupEmail_First(long contactGroupId,
        String emailAddress, long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchContactInfoException, SystemException {
        ContactInfo contactInfo = fetchByContactGroupEmail_First(contactGroupId,
                emailAddress, companyId, groupId, orderByComparator);

        if (contactInfo != null) {
            return contactInfo;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactGroupId=");
        msg.append(contactGroupId);

        msg.append(", emailAddress=");
        msg.append(emailAddress);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactInfoException(msg.toString());
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
    @Override
    public ContactInfo fetchByContactGroupEmail_First(long contactGroupId,
        String emailAddress, long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ContactInfo> list = findByContactGroupEmail(contactGroupId,
                emailAddress, companyId, groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public ContactInfo findByContactGroupEmail_Last(long contactGroupId,
        String emailAddress, long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchContactInfoException, SystemException {
        ContactInfo contactInfo = fetchByContactGroupEmail_Last(contactGroupId,
                emailAddress, companyId, groupId, orderByComparator);

        if (contactInfo != null) {
            return contactInfo;
        }

        StringBundler msg = new StringBundler(10);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("contactGroupId=");
        msg.append(contactGroupId);

        msg.append(", emailAddress=");
        msg.append(emailAddress);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContactInfoException(msg.toString());
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
    @Override
    public ContactInfo fetchByContactGroupEmail_Last(long contactGroupId,
        String emailAddress, long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByContactGroupEmail(contactGroupId, emailAddress,
                companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<ContactInfo> list = findByContactGroupEmail(contactGroupId,
                emailAddress, companyId, groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public ContactInfo[] findByContactGroupEmail_PrevAndNext(
        long contactInfoId, long contactGroupId, String emailAddress,
        long companyId, long groupId, OrderByComparator orderByComparator)
        throws NoSuchContactInfoException, SystemException {
        ContactInfo contactInfo = findByPrimaryKey(contactInfoId);

        Session session = null;

        try {
            session = openSession();

            ContactInfo[] array = new ContactInfoImpl[3];

            array[0] = getByContactGroupEmail_PrevAndNext(session, contactInfo,
                    contactGroupId, emailAddress, companyId, groupId,
                    orderByComparator, true);

            array[1] = contactInfo;

            array[2] = getByContactGroupEmail_PrevAndNext(session, contactInfo,
                    contactGroupId, emailAddress, companyId, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ContactInfo getByContactGroupEmail_PrevAndNext(Session session,
        ContactInfo contactInfo, long contactGroupId, String emailAddress,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTACTINFO_WHERE);

        query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_CONTACTGROUPID_2);

        boolean bindEmailAddress = false;

        if (emailAddress == null) {
            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_1);
        } else if (emailAddress.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_3);
        } else {
            bindEmailAddress = true;

            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_2);
        }

        query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_COMPANYID_2);

        query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ContactInfoModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(contactGroupId);

        if (bindEmailAddress) {
            qPos.add(emailAddress);
        }

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contactInfo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ContactInfo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
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
    @Override
    public void removeByContactGroupEmail(long contactGroupId,
        String emailAddress, long companyId, long groupId)
        throws SystemException {
        for (ContactInfo contactInfo : findByContactGroupEmail(contactGroupId,
                emailAddress, companyId, groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(contactInfo);
        }
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
    @Override
    public int countByContactGroupEmail(long contactGroupId,
        String emailAddress, long companyId, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTGROUPEMAIL;

        Object[] finderArgs = new Object[] {
                contactGroupId, emailAddress, companyId, groupId
            };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_CONTACTINFO_WHERE);

            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_CONTACTGROUPID_2);

            boolean bindEmailAddress = false;

            if (emailAddress == null) {
                query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_1);
            } else if (emailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_3);
            } else {
                bindEmailAddress = true;

                query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_EMAILADDRESS_2);
            }

            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_COMPANYID_2);

            query.append(_FINDER_COLUMN_CONTACTGROUPEMAIL_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(contactGroupId);

                if (bindEmailAddress) {
                    qPos.add(emailAddress);
                }

                qPos.add(companyId);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the contact info in the entity cache if it is enabled.
     *
     * @param contactInfo the contact info
     */
    @Override
    public void cacheResult(ContactInfo contactInfo) {
        EntityCacheUtil.putResult(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoImpl.class, contactInfo.getPrimaryKey(), contactInfo);

        contactInfo.resetOriginalValues();
    }

    /**
     * Caches the contact infos in the entity cache if it is enabled.
     *
     * @param contactInfos the contact infos
     */
    @Override
    public void cacheResult(List<ContactInfo> contactInfos) {
        for (ContactInfo contactInfo : contactInfos) {
            if (EntityCacheUtil.getResult(
                        ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
                        ContactInfoImpl.class, contactInfo.getPrimaryKey()) == null) {
                cacheResult(contactInfo);
            } else {
                contactInfo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all contact infos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ContactInfoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ContactInfoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the contact info.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ContactInfo contactInfo) {
        EntityCacheUtil.removeResult(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoImpl.class, contactInfo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ContactInfo> contactInfos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ContactInfo contactInfo : contactInfos) {
            EntityCacheUtil.removeResult(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
                ContactInfoImpl.class, contactInfo.getPrimaryKey());
        }
    }

    /**
     * Creates a new contact info with the primary key. Does not add the contact info to the database.
     *
     * @param contactInfoId the primary key for the new contact info
     * @return the new contact info
     */
    @Override
    public ContactInfo create(long contactInfoId) {
        ContactInfo contactInfo = new ContactInfoImpl();

        contactInfo.setNew(true);
        contactInfo.setPrimaryKey(contactInfoId);

        return contactInfo;
    }

    /**
     * Removes the contact info with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contactInfoId the primary key of the contact info
     * @return the contact info that was removed
     * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContactInfo remove(long contactInfoId)
        throws NoSuchContactInfoException, SystemException {
        return remove((Serializable) contactInfoId);
    }

    /**
     * Removes the contact info with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the contact info
     * @return the contact info that was removed
     * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContactInfo remove(Serializable primaryKey)
        throws NoSuchContactInfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ContactInfo contactInfo = (ContactInfo) session.get(ContactInfoImpl.class,
                    primaryKey);

            if (contactInfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchContactInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(contactInfo);
        } catch (NoSuchContactInfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ContactInfo removeImpl(ContactInfo contactInfo)
        throws SystemException {
        contactInfo = toUnwrappedModel(contactInfo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(contactInfo)) {
                contactInfo = (ContactInfo) session.get(ContactInfoImpl.class,
                        contactInfo.getPrimaryKeyObj());
            }

            if (contactInfo != null) {
                session.delete(contactInfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (contactInfo != null) {
            clearCache(contactInfo);
        }

        return contactInfo;
    }

    @Override
    public ContactInfo updateImpl(
        biz.fz5.app.kumquat.model.ContactInfo contactInfo)
        throws SystemException {
        contactInfo = toUnwrappedModel(contactInfo);

        boolean isNew = contactInfo.isNew();

        ContactInfoModelImpl contactInfoModelImpl = (ContactInfoModelImpl) contactInfo;

        Session session = null;

        try {
            session = openSession();

            if (contactInfo.isNew()) {
                session.save(contactInfo);

                contactInfo.setNew(false);
            } else {
                session.merge(contactInfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ContactInfoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((contactInfoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contactInfoModelImpl.getOriginalContactGroupId(),
                        contactInfoModelImpl.getOriginalCompanyId(),
                        contactInfoModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTGROUP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP,
                    args);

                args = new Object[] {
                        contactInfoModelImpl.getContactGroupId(),
                        contactInfoModelImpl.getCompanyId(),
                        contactInfoModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTGROUP,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP,
                    args);
            }

            if ((contactInfoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUPEMAIL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        contactInfoModelImpl.getOriginalContactGroupId(),
                        contactInfoModelImpl.getOriginalEmailAddress(),
                        contactInfoModelImpl.getOriginalCompanyId(),
                        contactInfoModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTGROUPEMAIL,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUPEMAIL,
                    args);

                args = new Object[] {
                        contactInfoModelImpl.getContactGroupId(),
                        contactInfoModelImpl.getEmailAddress(),
                        contactInfoModelImpl.getCompanyId(),
                        contactInfoModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTGROUPEMAIL,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUPEMAIL,
                    args);
            }
        }

        EntityCacheUtil.putResult(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
            ContactInfoImpl.class, contactInfo.getPrimaryKey(), contactInfo);

        return contactInfo;
    }

    protected ContactInfo toUnwrappedModel(ContactInfo contactInfo) {
        if (contactInfo instanceof ContactInfoImpl) {
            return contactInfo;
        }

        ContactInfoImpl contactInfoImpl = new ContactInfoImpl();

        contactInfoImpl.setNew(contactInfo.isNew());
        contactInfoImpl.setPrimaryKey(contactInfo.getPrimaryKey());

        contactInfoImpl.setContactInfoId(contactInfo.getContactInfoId());
        contactInfoImpl.setCompanyId(contactInfo.getCompanyId());
        contactInfoImpl.setGroupId(contactInfo.getGroupId());
        contactInfoImpl.setUserId(contactInfo.getUserId());
        contactInfoImpl.setUserName(contactInfo.getUserName());
        contactInfoImpl.setCreateDate(contactInfo.getCreateDate());
        contactInfoImpl.setModifiedDate(contactInfo.getModifiedDate());
        contactInfoImpl.setFirstName(contactInfo.getFirstName());
        contactInfoImpl.setLastName(contactInfo.getLastName());
        contactInfoImpl.setTelephoneNumber(contactInfo.getTelephoneNumber());
        contactInfoImpl.setEmailAddress(contactInfo.getEmailAddress());
        contactInfoImpl.setAgreedToPrivacy(contactInfo.isAgreedToPrivacy());
        contactInfoImpl.setContactGroupId(contactInfo.getContactGroupId());

        return contactInfoImpl;
    }

    /**
     * Returns the contact info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the contact info
     * @return the contact info
     * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContactInfo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchContactInfoException, SystemException {
        ContactInfo contactInfo = fetchByPrimaryKey(primaryKey);

        if (contactInfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchContactInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return contactInfo;
    }

    /**
     * Returns the contact info with the primary key or throws a {@link biz.fz5.app.kumquat.NoSuchContactInfoException} if it could not be found.
     *
     * @param contactInfoId the primary key of the contact info
     * @return the contact info
     * @throws biz.fz5.app.kumquat.NoSuchContactInfoException if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContactInfo findByPrimaryKey(long contactInfoId)
        throws NoSuchContactInfoException, SystemException {
        return findByPrimaryKey((Serializable) contactInfoId);
    }

    /**
     * Returns the contact info with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the contact info
     * @return the contact info, or <code>null</code> if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContactInfo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ContactInfo contactInfo = (ContactInfo) EntityCacheUtil.getResult(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
                ContactInfoImpl.class, primaryKey);

        if (contactInfo == _nullContactInfo) {
            return null;
        }

        if (contactInfo == null) {
            Session session = null;

            try {
                session = openSession();

                contactInfo = (ContactInfo) session.get(ContactInfoImpl.class,
                        primaryKey);

                if (contactInfo != null) {
                    cacheResult(contactInfo);
                } else {
                    EntityCacheUtil.putResult(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
                        ContactInfoImpl.class, primaryKey, _nullContactInfo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ContactInfoModelImpl.ENTITY_CACHE_ENABLED,
                    ContactInfoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return contactInfo;
    }

    /**
     * Returns the contact info with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param contactInfoId the primary key of the contact info
     * @return the contact info, or <code>null</code> if a contact info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContactInfo fetchByPrimaryKey(long contactInfoId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) contactInfoId);
    }

    /**
     * Returns all the contact infos.
     *
     * @return the contact infos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ContactInfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<ContactInfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<ContactInfo> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<ContactInfo> list = (List<ContactInfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONTACTINFO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONTACTINFO;

                if (pagination) {
                    sql = sql.concat(ContactInfoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ContactInfo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ContactInfo>(list);
                } else {
                    list = (List<ContactInfo>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the contact infos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ContactInfo contactInfo : findAll()) {
            remove(contactInfo);
        }
    }

    /**
     * Returns the number of contact infos.
     *
     * @return the number of contact infos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CONTACTINFO);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the contact info persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.biz.fz5.app.kumquat.model.ContactInfo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ContactInfo>> listenersList = new ArrayList<ModelListener<ContactInfo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ContactInfo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ContactInfoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
