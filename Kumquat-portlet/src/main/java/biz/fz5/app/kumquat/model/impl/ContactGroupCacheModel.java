package biz.fz5.app.kumquat.model.impl;

import biz.fz5.app.kumquat.model.ContactGroup;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContactGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ContactGroup
 * @generated
 */
public class ContactGroupCacheModel implements CacheModel<ContactGroup>,
    Externalizable {
    public long contactGroupId;
    public long companyId;
    public long groupId;
    public String name;
    public String description;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{contactGroupId=");
        sb.append(contactGroupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ContactGroup toEntityModel() {
        ContactGroupImpl contactGroupImpl = new ContactGroupImpl();

        contactGroupImpl.setContactGroupId(contactGroupId);
        contactGroupImpl.setCompanyId(companyId);
        contactGroupImpl.setGroupId(groupId);

        if (name == null) {
            contactGroupImpl.setName(StringPool.BLANK);
        } else {
            contactGroupImpl.setName(name);
        }

        if (description == null) {
            contactGroupImpl.setDescription(StringPool.BLANK);
        } else {
            contactGroupImpl.setDescription(description);
        }

        contactGroupImpl.resetOriginalValues();

        return contactGroupImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        contactGroupId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(contactGroupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }
    }
}
