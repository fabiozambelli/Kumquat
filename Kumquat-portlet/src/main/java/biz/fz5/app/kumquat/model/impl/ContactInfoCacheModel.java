package biz.fz5.app.kumquat.model.impl;

import biz.fz5.app.kumquat.model.ContactInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactInfo
 * @generated
 */
public class ContactInfoCacheModel implements CacheModel<ContactInfo>,
    Externalizable {
    public long contactInfoId;
    public long companyId;
    public long groupId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String firstName;
    public String lastName;
    public String telephoneNumber;
    public String emailAddress;
    public boolean agreedToPrivacy;
    public long contactGroupId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{contactInfoId=");
        sb.append(contactInfoId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append(", telephoneNumber=");
        sb.append(telephoneNumber);
        sb.append(", emailAddress=");
        sb.append(emailAddress);
        sb.append(", agreedToPrivacy=");
        sb.append(agreedToPrivacy);
        sb.append(", contactGroupId=");
        sb.append(contactGroupId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ContactInfo toEntityModel() {
        ContactInfoImpl contactInfoImpl = new ContactInfoImpl();

        contactInfoImpl.setContactInfoId(contactInfoId);
        contactInfoImpl.setCompanyId(companyId);
        contactInfoImpl.setGroupId(groupId);
        contactInfoImpl.setUserId(userId);

        if (userName == null) {
            contactInfoImpl.setUserName(StringPool.BLANK);
        } else {
            contactInfoImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            contactInfoImpl.setCreateDate(null);
        } else {
            contactInfoImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            contactInfoImpl.setModifiedDate(null);
        } else {
            contactInfoImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (firstName == null) {
            contactInfoImpl.setFirstName(StringPool.BLANK);
        } else {
            contactInfoImpl.setFirstName(firstName);
        }

        if (lastName == null) {
            contactInfoImpl.setLastName(StringPool.BLANK);
        } else {
            contactInfoImpl.setLastName(lastName);
        }

        if (telephoneNumber == null) {
            contactInfoImpl.setTelephoneNumber(StringPool.BLANK);
        } else {
            contactInfoImpl.setTelephoneNumber(telephoneNumber);
        }

        if (emailAddress == null) {
            contactInfoImpl.setEmailAddress(StringPool.BLANK);
        } else {
            contactInfoImpl.setEmailAddress(emailAddress);
        }

        contactInfoImpl.setAgreedToPrivacy(agreedToPrivacy);
        contactInfoImpl.setContactGroupId(contactGroupId);

        contactInfoImpl.resetOriginalValues();

        return contactInfoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        contactInfoId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        firstName = objectInput.readUTF();
        lastName = objectInput.readUTF();
        telephoneNumber = objectInput.readUTF();
        emailAddress = objectInput.readUTF();
        agreedToPrivacy = objectInput.readBoolean();
        contactGroupId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(contactInfoId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (firstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(firstName);
        }

        if (lastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lastName);
        }

        if (telephoneNumber == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(telephoneNumber);
        }

        if (emailAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emailAddress);
        }

        objectOutput.writeBoolean(agreedToPrivacy);
        objectOutput.writeLong(contactGroupId);
    }
}
