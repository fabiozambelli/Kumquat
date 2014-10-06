package biz.fz5.app.kumquat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContactGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactGroup
 * @generated
 */
public class ContactGroupWrapper implements ContactGroup,
    ModelWrapper<ContactGroup> {
    private ContactGroup _contactGroup;

    public ContactGroupWrapper(ContactGroup contactGroup) {
        _contactGroup = contactGroup;
    }

    @Override
    public Class<?> getModelClass() {
        return ContactGroup.class;
    }

    @Override
    public String getModelClassName() {
        return ContactGroup.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactGroupId", getContactGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contactGroupId = (Long) attributes.get("contactGroupId");

        if (contactGroupId != null) {
            setContactGroupId(contactGroupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    /**
    * Returns the primary key of this contact group.
    *
    * @return the primary key of this contact group
    */
    @Override
    public long getPrimaryKey() {
        return _contactGroup.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contact group.
    *
    * @param primaryKey the primary key of this contact group
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _contactGroup.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contact group ID of this contact group.
    *
    * @return the contact group ID of this contact group
    */
    @Override
    public long getContactGroupId() {
        return _contactGroup.getContactGroupId();
    }

    /**
    * Sets the contact group ID of this contact group.
    *
    * @param contactGroupId the contact group ID of this contact group
    */
    @Override
    public void setContactGroupId(long contactGroupId) {
        _contactGroup.setContactGroupId(contactGroupId);
    }

    /**
    * Returns the company ID of this contact group.
    *
    * @return the company ID of this contact group
    */
    @Override
    public long getCompanyId() {
        return _contactGroup.getCompanyId();
    }

    /**
    * Sets the company ID of this contact group.
    *
    * @param companyId the company ID of this contact group
    */
    @Override
    public void setCompanyId(long companyId) {
        _contactGroup.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this contact group.
    *
    * @return the group ID of this contact group
    */
    @Override
    public long getGroupId() {
        return _contactGroup.getGroupId();
    }

    /**
    * Sets the group ID of this contact group.
    *
    * @param groupId the group ID of this contact group
    */
    @Override
    public void setGroupId(long groupId) {
        _contactGroup.setGroupId(groupId);
    }

    /**
    * Returns the name of this contact group.
    *
    * @return the name of this contact group
    */
    @Override
    public java.lang.String getName() {
        return _contactGroup.getName();
    }

    /**
    * Sets the name of this contact group.
    *
    * @param name the name of this contact group
    */
    @Override
    public void setName(java.lang.String name) {
        _contactGroup.setName(name);
    }

    /**
    * Returns the description of this contact group.
    *
    * @return the description of this contact group
    */
    @Override
    public java.lang.String getDescription() {
        return _contactGroup.getDescription();
    }

    /**
    * Sets the description of this contact group.
    *
    * @param description the description of this contact group
    */
    @Override
    public void setDescription(java.lang.String description) {
        _contactGroup.setDescription(description);
    }

    @Override
    public boolean isNew() {
        return _contactGroup.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _contactGroup.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _contactGroup.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _contactGroup.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _contactGroup.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _contactGroup.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contactGroup.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contactGroup.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _contactGroup.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _contactGroup.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contactGroup.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContactGroupWrapper((ContactGroup) _contactGroup.clone());
    }

    @Override
    public int compareTo(ContactGroup contactGroup) {
        return _contactGroup.compareTo(contactGroup);
    }

    @Override
    public int hashCode() {
        return _contactGroup.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ContactGroup> toCacheModel() {
        return _contactGroup.toCacheModel();
    }

    @Override
    public ContactGroup toEscapedModel() {
        return new ContactGroupWrapper(_contactGroup.toEscapedModel());
    }

    @Override
    public ContactGroup toUnescapedModel() {
        return new ContactGroupWrapper(_contactGroup.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contactGroup.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _contactGroup.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contactGroup.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactGroupWrapper)) {
            return false;
        }

        ContactGroupWrapper contactGroupWrapper = (ContactGroupWrapper) obj;

        if (Validator.equals(_contactGroup, contactGroupWrapper._contactGroup)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ContactGroup getWrappedContactGroup() {
        return _contactGroup;
    }

    @Override
    public ContactGroup getWrappedModel() {
        return _contactGroup;
    }

    @Override
    public void resetOriginalValues() {
        _contactGroup.resetOriginalValues();
    }
}
