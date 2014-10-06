package biz.fz5.app.kumquat.model;

import biz.fz5.app.kumquat.service.ClpSerializer;
import biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ContactInfoClp extends BaseModelImpl<ContactInfo>
    implements ContactInfo {
    private long _contactInfoId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _firstName;
    private String _lastName;
    private String _telephoneNumber;
    private String _emailAddress;
    private boolean _agreedToPrivacy;
    private long _contactGroupId;
    private BaseModel<?> _contactInfoRemoteModel;

    public ContactInfoClp() {
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

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setContactInfoId", long.class);

                method.invoke(_contactInfoRemoteModel, contactInfoId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_contactInfoRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_contactInfoRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_contactInfoRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
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
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_contactInfoRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_contactInfoRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_contactInfoRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setFirstName", String.class);

                method.invoke(_contactInfoRemoteModel, firstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setLastName", String.class);

                method.invoke(_contactInfoRemoteModel, lastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTelephoneNumber() {
        return _telephoneNumber;
    }

    @Override
    public void setTelephoneNumber(String telephoneNumber) {
        _telephoneNumber = telephoneNumber;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setTelephoneNumber",
                        String.class);

                method.invoke(_contactInfoRemoteModel, telephoneNumber);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailAddress() {
        return _emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailAddress", String.class);

                method.invoke(_contactInfoRemoteModel, emailAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
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

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setAgreedToPrivacy",
                        boolean.class);

                method.invoke(_contactInfoRemoteModel, agreedToPrivacy);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getContactGroupId() {
        return _contactGroupId;
    }

    @Override
    public void setContactGroupId(long contactGroupId) {
        _contactGroupId = contactGroupId;

        if (_contactInfoRemoteModel != null) {
            try {
                Class<?> clazz = _contactInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setContactGroupId", long.class);

                method.invoke(_contactInfoRemoteModel, contactGroupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getContactInfoRemoteModel() {
        return _contactInfoRemoteModel;
    }

    public void setContactInfoRemoteModel(BaseModel<?> contactInfoRemoteModel) {
        _contactInfoRemoteModel = contactInfoRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _contactInfoRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_contactInfoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContactInfoLocalServiceUtil.addContactInfo(this);
        } else {
            ContactInfoLocalServiceUtil.updateContactInfo(this);
        }
    }

    @Override
    public ContactInfo toEscapedModel() {
        return (ContactInfo) ProxyUtil.newProxyInstance(ContactInfo.class.getClassLoader(),
            new Class[] { ContactInfo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContactInfoClp clone = new ContactInfoClp();

        clone.setContactInfoId(getContactInfoId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setFirstName(getFirstName());
        clone.setLastName(getLastName());
        clone.setTelephoneNumber(getTelephoneNumber());
        clone.setEmailAddress(getEmailAddress());
        clone.setAgreedToPrivacy(getAgreedToPrivacy());
        clone.setContactGroupId(getContactGroupId());

        return clone;
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

        if (!(obj instanceof ContactInfoClp)) {
            return false;
        }

        ContactInfoClp contactInfo = (ContactInfoClp) obj;

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
