package biz.fz5.app.kumquat.model.impl;

import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.model.ContactInfoModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ContactInfo service. Represents a row in the &quot;Kumquat_ContactInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link biz.fz5.app.kumquat.model.ContactInfoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfoImpl
 * @see biz.fz5.app.kumquat.model.ContactInfo
 * @see biz.fz5.app.kumquat.model.ContactInfoModel
 * @generated
 */
public class ContactInfoModelImpl extends BaseModelImpl<ContactInfo>
    implements ContactInfoModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contact info model instance should use the {@link biz.fz5.app.kumquat.model.ContactInfo} interface instead.
     */
    public static final String TABLE_NAME = "Kumquat_ContactInfo";
    public static final Object[][] TABLE_COLUMNS = {
            { "contactInfoId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "firstName", Types.VARCHAR },
            { "lastName", Types.VARCHAR },
            { "telephoneNumber", Types.VARCHAR },
            { "emailAddress", Types.VARCHAR },
            { "agreedToPrivacy", Types.BOOLEAN },
            { "contactGroupId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table Kumquat_ContactInfo (contactInfoId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,telephoneNumber VARCHAR(75) null,emailAddress VARCHAR(75) null,agreedToPrivacy BOOLEAN,contactGroupId LONG)";
    public static final String TABLE_SQL_DROP = "drop table Kumquat_ContactInfo";
    public static final String ORDER_BY_JPQL = " ORDER BY contactInfo.createDate DESC";
    public static final String ORDER_BY_SQL = " ORDER BY Kumquat_ContactInfo.createDate DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.biz.fz5.app.kumquat.model.ContactInfo"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.biz.fz5.app.kumquat.model.ContactInfo"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.biz.fz5.app.kumquat.model.ContactInfo"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long CONTACTGROUPID_COLUMN_BITMASK = 2L;
    public static long EMAILADDRESS_COLUMN_BITMASK = 4L;
    public static long GROUPID_COLUMN_BITMASK = 8L;
    public static long CREATEDATE_COLUMN_BITMASK = 16L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.biz.fz5.app.kumquat.model.ContactInfo"));
    private static ClassLoader _classLoader = ContactInfo.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ContactInfo.class
        };
    private long _contactInfoId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _firstName;
    private String _lastName;
    private String _telephoneNumber;
    private String _emailAddress;
    private String _originalEmailAddress;
    private boolean _agreedToPrivacy;
    private long _contactGroupId;
    private long _originalContactGroupId;
    private boolean _setOriginalContactGroupId;
    private long _columnBitmask;
    private ContactInfo _escapedModel;

    public ContactInfoModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _contactInfoId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setContactInfoId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _contactInfoId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ContactInfo.class;
    }

    @Override
    public String getModelClassName() {
        return ContactInfo.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactInfoId", getContactInfoId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("firstName", getFirstName());
        attributes.put("lastName", getLastName());
        attributes.put("telephoneNumber", getTelephoneNumber());
        attributes.put("emailAddress", getEmailAddress());
        attributes.put("agreedToPrivacy", getAgreedToPrivacy());
        attributes.put("contactGroupId", getContactGroupId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contactInfoId = (Long) attributes.get("contactInfoId");

        if (contactInfoId != null) {
            setContactInfoId(contactInfoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }

        String telephoneNumber = (String) attributes.get("telephoneNumber");

        if (telephoneNumber != null) {
            setTelephoneNumber(telephoneNumber);
        }

        String emailAddress = (String) attributes.get("emailAddress");

        if (emailAddress != null) {
            setEmailAddress(emailAddress);
        }

        Boolean agreedToPrivacy = (Boolean) attributes.get("agreedToPrivacy");

        if (agreedToPrivacy != null) {
            setAgreedToPrivacy(agreedToPrivacy);
        }

        Long contactGroupId = (Long) attributes.get("contactGroupId");

        if (contactGroupId != null) {
            setContactGroupId(contactGroupId);
        }
    }

    @Override
    public long getContactInfoId() {
        return _contactInfoId;
    }

    @Override
    public void setContactInfoId(long contactInfoId) {
        _contactInfoId = contactInfoId;
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _columnBitmask = -1L;

        _createDate = createDate;
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @Override
    public String getFirstName() {
        if (_firstName == null) {
            return StringPool.BLANK;
        } else {
            return _firstName;
        }
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    @Override
    public String getLastName() {
        if (_lastName == null) {
            return StringPool.BLANK;
        } else {
            return _lastName;
        }
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    @Override
    public String getTelephoneNumber() {
        if (_telephoneNumber == null) {
            return StringPool.BLANK;
        } else {
            return _telephoneNumber;
        }
    }

    @Override
    public void setTelephoneNumber(String telephoneNumber) {
        _telephoneNumber = telephoneNumber;
    }

    @Override
    public String getEmailAddress() {
        if (_emailAddress == null) {
            return StringPool.BLANK;
        } else {
            return _emailAddress;
        }
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        _columnBitmask |= EMAILADDRESS_COLUMN_BITMASK;

        if (_originalEmailAddress == null) {
            _originalEmailAddress = _emailAddress;
        }

        _emailAddress = emailAddress;
    }

    public String getOriginalEmailAddress() {
        return GetterUtil.getString(_originalEmailAddress);
    }

    @Override
    public boolean getAgreedToPrivacy() {
        return _agreedToPrivacy;
    }

    @Override
    public boolean isAgreedToPrivacy() {
        return _agreedToPrivacy;
    }

    @Override
    public void setAgreedToPrivacy(boolean agreedToPrivacy) {
        _agreedToPrivacy = agreedToPrivacy;
    }

    @Override
    public long getContactGroupId() {
        return _contactGroupId;
    }

    @Override
    public void setContactGroupId(long contactGroupId) {
        _columnBitmask |= CONTACTGROUPID_COLUMN_BITMASK;

        if (!_setOriginalContactGroupId) {
            _setOriginalContactGroupId = true;

            _originalContactGroupId = _contactGroupId;
        }

        _contactGroupId = contactGroupId;
    }

    public long getOriginalContactGroupId() {
        return _originalContactGroupId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            ContactInfo.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ContactInfo toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ContactInfo) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ContactInfoImpl contactInfoImpl = new ContactInfoImpl();

        contactInfoImpl.setContactInfoId(getContactInfoId());
        contactInfoImpl.setCompanyId(getCompanyId());
        contactInfoImpl.setGroupId(getGroupId());
        contactInfoImpl.setUserId(getUserId());
        contactInfoImpl.setUserName(getUserName());
        contactInfoImpl.setCreateDate(getCreateDate());
        contactInfoImpl.setModifiedDate(getModifiedDate());
        contactInfoImpl.setFirstName(getFirstName());
        contactInfoImpl.setLastName(getLastName());
        contactInfoImpl.setTelephoneNumber(getTelephoneNumber());
        contactInfoImpl.setEmailAddress(getEmailAddress());
        contactInfoImpl.setAgreedToPrivacy(getAgreedToPrivacy());
        contactInfoImpl.setContactGroupId(getContactGroupId());

        contactInfoImpl.resetOriginalValues();

        return contactInfoImpl;
    }

    @Override
    public int compareTo(ContactInfo contactInfo) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), contactInfo.getCreateDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactInfo)) {
            return false;
        }

        ContactInfo contactInfo = (ContactInfo) obj;

        long primaryKey = contactInfo.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        ContactInfoModelImpl contactInfoModelImpl = this;

        contactInfoModelImpl._originalCompanyId = contactInfoModelImpl._companyId;

        contactInfoModelImpl._setOriginalCompanyId = false;

        contactInfoModelImpl._originalGroupId = contactInfoModelImpl._groupId;

        contactInfoModelImpl._setOriginalGroupId = false;

        contactInfoModelImpl._originalEmailAddress = contactInfoModelImpl._emailAddress;

        contactInfoModelImpl._originalContactGroupId = contactInfoModelImpl._contactGroupId;

        contactInfoModelImpl._setOriginalContactGroupId = false;

        contactInfoModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ContactInfo> toCacheModel() {
        ContactInfoCacheModel contactInfoCacheModel = new ContactInfoCacheModel();

        contactInfoCacheModel.contactInfoId = getContactInfoId();

        contactInfoCacheModel.companyId = getCompanyId();

        contactInfoCacheModel.groupId = getGroupId();

        contactInfoCacheModel.userId = getUserId();

        contactInfoCacheModel.userName = getUserName();

        String userName = contactInfoCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            contactInfoCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            contactInfoCacheModel.createDate = createDate.getTime();
        } else {
            contactInfoCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            contactInfoCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            contactInfoCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        contactInfoCacheModel.firstName = getFirstName();

        String firstName = contactInfoCacheModel.firstName;

        if ((firstName != null) && (firstName.length() == 0)) {
            contactInfoCacheModel.firstName = null;
        }

        contactInfoCacheModel.lastName = getLastName();

        String lastName = contactInfoCacheModel.lastName;

        if ((lastName != null) && (lastName.length() == 0)) {
            contactInfoCacheModel.lastName = null;
        }

        contactInfoCacheModel.telephoneNumber = getTelephoneNumber();

        String telephoneNumber = contactInfoCacheModel.telephoneNumber;

        if ((telephoneNumber != null) && (telephoneNumber.length() == 0)) {
            contactInfoCacheModel.telephoneNumber = null;
        }

        contactInfoCacheModel.emailAddress = getEmailAddress();

        String emailAddress = contactInfoCacheModel.emailAddress;

        if ((emailAddress != null) && (emailAddress.length() == 0)) {
            contactInfoCacheModel.emailAddress = null;
        }

        contactInfoCacheModel.agreedToPrivacy = getAgreedToPrivacy();

        contactInfoCacheModel.contactGroupId = getContactGroupId();

        return contactInfoCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{contactInfoId=");
        sb.append(getContactInfoId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append(", telephoneNumber=");
        sb.append(getTelephoneNumber());
        sb.append(", emailAddress=");
        sb.append(getEmailAddress());
        sb.append(", agreedToPrivacy=");
        sb.append(getAgreedToPrivacy());
        sb.append(", contactGroupId=");
        sb.append(getContactGroupId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("biz.fz5.app.kumquat.model.ContactInfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contactInfoId</column-name><column-value><![CDATA[");
        sb.append(getContactInfoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>telephoneNumber</column-name><column-value><![CDATA[");
        sb.append(getTelephoneNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailAddress</column-name><column-value><![CDATA[");
        sb.append(getEmailAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>agreedToPrivacy</column-name><column-value><![CDATA[");
        sb.append(getAgreedToPrivacy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactGroupId</column-name><column-value><![CDATA[");
        sb.append(getContactGroupId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}