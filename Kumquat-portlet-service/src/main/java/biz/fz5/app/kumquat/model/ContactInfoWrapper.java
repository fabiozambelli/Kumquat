package biz.fz5.app.kumquat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContactInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfo
 * @generated
 */
public class ContactInfoWrapper implements ContactInfo,
    ModelWrapper<ContactInfo> {
    private ContactInfo _contactInfo;

    public ContactInfoWrapper(ContactInfo contactInfo) {
        _contactInfo = contactInfo;
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

    /**
    * Returns the primary key of this contact info.
    *
    * @return the primary key of this contact info
    */
    @Override
    public long getPrimaryKey() {
        return _contactInfo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contact info.
    *
    * @param primaryKey the primary key of this contact info
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _contactInfo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contact info ID of this contact info.
    *
    * @return the contact info ID of this contact info
    */
    @Override
    public long getContactInfoId() {
        return _contactInfo.getContactInfoId();
    }

    /**
    * Sets the contact info ID of this contact info.
    *
    * @param contactInfoId the contact info ID of this contact info
    */
    @Override
    public void setContactInfoId(long contactInfoId) {
        _contactInfo.setContactInfoId(contactInfoId);
    }

    /**
    * Returns the company ID of this contact info.
    *
    * @return the company ID of this contact info
    */
    @Override
    public long getCompanyId() {
        return _contactInfo.getCompanyId();
    }

    /**
    * Sets the company ID of this contact info.
    *
    * @param companyId the company ID of this contact info
    */
    @Override
    public void setCompanyId(long companyId) {
        _contactInfo.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this contact info.
    *
    * @return the group ID of this contact info
    */
    @Override
    public long getGroupId() {
        return _contactInfo.getGroupId();
    }

    /**
    * Sets the group ID of this contact info.
    *
    * @param groupId the group ID of this contact info
    */
    @Override
    public void setGroupId(long groupId) {
        _contactInfo.setGroupId(groupId);
    }

    /**
    * Returns the user ID of this contact info.
    *
    * @return the user ID of this contact info
    */
    @Override
    public long getUserId() {
        return _contactInfo.getUserId();
    }

    /**
    * Sets the user ID of this contact info.
    *
    * @param userId the user ID of this contact info
    */
    @Override
    public void setUserId(long userId) {
        _contactInfo.setUserId(userId);
    }

    /**
    * Returns the user uuid of this contact info.
    *
    * @return the user uuid of this contact info
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contactInfo.getUserUuid();
    }

    /**
    * Sets the user uuid of this contact info.
    *
    * @param userUuid the user uuid of this contact info
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _contactInfo.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this contact info.
    *
    * @return the user name of this contact info
    */
    @Override
    public java.lang.String getUserName() {
        return _contactInfo.getUserName();
    }

    /**
    * Sets the user name of this contact info.
    *
    * @param userName the user name of this contact info
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _contactInfo.setUserName(userName);
    }

    /**
    * Returns the create date of this contact info.
    *
    * @return the create date of this contact info
    */
    @Override
    public java.util.Date getCreateDate() {
        return _contactInfo.getCreateDate();
    }

    /**
    * Sets the create date of this contact info.
    *
    * @param createDate the create date of this contact info
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _contactInfo.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this contact info.
    *
    * @return the modified date of this contact info
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _contactInfo.getModifiedDate();
    }

    /**
    * Sets the modified date of this contact info.
    *
    * @param modifiedDate the modified date of this contact info
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _contactInfo.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the first name of this contact info.
    *
    * @return the first name of this contact info
    */
    @Override
    public java.lang.String getFirstName() {
        return _contactInfo.getFirstName();
    }

    /**
    * Sets the first name of this contact info.
    *
    * @param firstName the first name of this contact info
    */
    @Override
    public void setFirstName(java.lang.String firstName) {
        _contactInfo.setFirstName(firstName);
    }

    /**
    * Returns the last name of this contact info.
    *
    * @return the last name of this contact info
    */
    @Override
    public java.lang.String getLastName() {
        return _contactInfo.getLastName();
    }

    /**
    * Sets the last name of this contact info.
    *
    * @param lastName the last name of this contact info
    */
    @Override
    public void setLastName(java.lang.String lastName) {
        _contactInfo.setLastName(lastName);
    }

    /**
    * Returns the telephone number of this contact info.
    *
    * @return the telephone number of this contact info
    */
    @Override
    public java.lang.String getTelephoneNumber() {
        return _contactInfo.getTelephoneNumber();
    }

    /**
    * Sets the telephone number of this contact info.
    *
    * @param telephoneNumber the telephone number of this contact info
    */
    @Override
    public void setTelephoneNumber(java.lang.String telephoneNumber) {
        _contactInfo.setTelephoneNumber(telephoneNumber);
    }

    /**
    * Returns the email address of this contact info.
    *
    * @return the email address of this contact info
    */
    @Override
    public java.lang.String getEmailAddress() {
        return _contactInfo.getEmailAddress();
    }

    /**
    * Sets the email address of this contact info.
    *
    * @param emailAddress the email address of this contact info
    */
    @Override
    public void setEmailAddress(java.lang.String emailAddress) {
        _contactInfo.setEmailAddress(emailAddress);
    }

    /**
    * Returns the agreed to privacy of this contact info.
    *
    * @return the agreed to privacy of this contact info
    */
    @Override
    public boolean getAgreedToPrivacy() {
        return _contactInfo.getAgreedToPrivacy();
    }

    /**
    * Returns <code>true</code> if this contact info is agreed to privacy.
    *
    * @return <code>true</code> if this contact info is agreed to privacy; <code>false</code> otherwise
    */
    @Override
    public boolean isAgreedToPrivacy() {
        return _contactInfo.isAgreedToPrivacy();
    }

    /**
    * Sets whether this contact info is agreed to privacy.
    *
    * @param agreedToPrivacy the agreed to privacy of this contact info
    */
    @Override
    public void setAgreedToPrivacy(boolean agreedToPrivacy) {
        _contactInfo.setAgreedToPrivacy(agreedToPrivacy);
    }

    /**
    * Returns the contact group ID of this contact info.
    *
    * @return the contact group ID of this contact info
    */
    @Override
    public long getContactGroupId() {
        return _contactInfo.getContactGroupId();
    }

    /**
    * Sets the contact group ID of this contact info.
    *
    * @param contactGroupId the contact group ID of this contact info
    */
    @Override
    public void setContactGroupId(long contactGroupId) {
        _contactInfo.setContactGroupId(contactGroupId);
    }

    @Override
    public boolean isNew() {
        return _contactInfo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _contactInfo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _contactInfo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _contactInfo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _contactInfo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _contactInfo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contactInfo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contactInfo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _contactInfo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _contactInfo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contactInfo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContactInfoWrapper((ContactInfo) _contactInfo.clone());
    }

    @Override
    public int compareTo(ContactInfo contactInfo) {
        return _contactInfo.compareTo(contactInfo);
    }

    @Override
    public int hashCode() {
        return _contactInfo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ContactInfo> toCacheModel() {
        return _contactInfo.toCacheModel();
    }

    @Override
    public ContactInfo toEscapedModel() {
        return new ContactInfoWrapper(_contactInfo.toEscapedModel());
    }

    @Override
    public ContactInfo toUnescapedModel() {
        return new ContactInfoWrapper(_contactInfo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contactInfo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _contactInfo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contactInfo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactInfoWrapper)) {
            return false;
        }

        ContactInfoWrapper contactInfoWrapper = (ContactInfoWrapper) obj;

        if (Validator.equals(_contactInfo, contactInfoWrapper._contactInfo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ContactInfo getWrappedContactInfo() {
        return _contactInfo;
    }

    @Override
    public ContactInfo getWrappedModel() {
        return _contactInfo;
    }

    @Override
    public void resetOriginalValues() {
        _contactInfo.resetOriginalValues();
    }
}
