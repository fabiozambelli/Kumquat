package biz.fz5.app.kumquat.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ContactInfo service. Represents a row in the &quot;Kumquat_ContactInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link biz.fz5.app.kumquat.model.impl.ContactInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfo
 * @see biz.fz5.app.kumquat.model.impl.ContactInfoImpl
 * @see biz.fz5.app.kumquat.model.impl.ContactInfoModelImpl
 * @generated
 */
public interface ContactInfoModel extends BaseModel<ContactInfo>, GroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a contact info model instance should use the {@link ContactInfo} interface instead.
     */

    /**
     * Returns the primary key of this contact info.
     *
     * @return the primary key of this contact info
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this contact info.
     *
     * @param primaryKey the primary key of this contact info
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the contact info ID of this contact info.
     *
     * @return the contact info ID of this contact info
     */
    public long getContactInfoId();

    /**
     * Sets the contact info ID of this contact info.
     *
     * @param contactInfoId the contact info ID of this contact info
     */
    public void setContactInfoId(long contactInfoId);

    /**
     * Returns the company ID of this contact info.
     *
     * @return the company ID of this contact info
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this contact info.
     *
     * @param companyId the company ID of this contact info
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this contact info.
     *
     * @return the group ID of this contact info
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this contact info.
     *
     * @param groupId the group ID of this contact info
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the user ID of this contact info.
     *
     * @return the user ID of this contact info
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this contact info.
     *
     * @param userId the user ID of this contact info
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this contact info.
     *
     * @return the user uuid of this contact info
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this contact info.
     *
     * @param userUuid the user uuid of this contact info
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this contact info.
     *
     * @return the user name of this contact info
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this contact info.
     *
     * @param userName the user name of this contact info
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this contact info.
     *
     * @return the create date of this contact info
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this contact info.
     *
     * @param createDate the create date of this contact info
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this contact info.
     *
     * @return the modified date of this contact info
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this contact info.
     *
     * @param modifiedDate the modified date of this contact info
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the first name of this contact info.
     *
     * @return the first name of this contact info
     */
    @AutoEscape
    public String getFirstName();

    /**
     * Sets the first name of this contact info.
     *
     * @param firstName the first name of this contact info
     */
    public void setFirstName(String firstName);

    /**
     * Returns the last name of this contact info.
     *
     * @return the last name of this contact info
     */
    @AutoEscape
    public String getLastName();

    /**
     * Sets the last name of this contact info.
     *
     * @param lastName the last name of this contact info
     */
    public void setLastName(String lastName);

    /**
     * Returns the telephone number of this contact info.
     *
     * @return the telephone number of this contact info
     */
    @AutoEscape
    public String getTelephoneNumber();

    /**
     * Sets the telephone number of this contact info.
     *
     * @param telephoneNumber the telephone number of this contact info
     */
    public void setTelephoneNumber(String telephoneNumber);

    /**
     * Returns the email address of this contact info.
     *
     * @return the email address of this contact info
     */
    @AutoEscape
    public String getEmailAddress();

    /**
     * Sets the email address of this contact info.
     *
     * @param emailAddress the email address of this contact info
     */
    public void setEmailAddress(String emailAddress);

    /**
     * Returns the agreed to privacy of this contact info.
     *
     * @return the agreed to privacy of this contact info
     */
    public boolean getAgreedToPrivacy();

    /**
     * Returns <code>true</code> if this contact info is agreed to privacy.
     *
     * @return <code>true</code> if this contact info is agreed to privacy; <code>false</code> otherwise
     */
    public boolean isAgreedToPrivacy();

    /**
     * Sets whether this contact info is agreed to privacy.
     *
     * @param agreedToPrivacy the agreed to privacy of this contact info
     */
    public void setAgreedToPrivacy(boolean agreedToPrivacy);

    /**
     * Returns the contact group ID of this contact info.
     *
     * @return the contact group ID of this contact info
     */
    public long getContactGroupId();

    /**
     * Sets the contact group ID of this contact info.
     *
     * @param contactGroupId the contact group ID of this contact info
     */
    public void setContactGroupId(long contactGroupId);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(ContactInfo contactInfo);

    @Override
    public int hashCode();

    @Override
    public CacheModel<ContactInfo> toCacheModel();

    @Override
    public ContactInfo toEscapedModel();

    @Override
    public ContactInfo toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
