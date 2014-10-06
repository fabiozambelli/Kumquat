package biz.fz5.app.kumquat.model;

import biz.fz5.app.kumquat.service.ClpSerializer;
import biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ContactGroupClp extends BaseModelImpl<ContactGroup>
    implements ContactGroup {
    private long _contactGroupId;
    private long _companyId;
    private long _groupId;
    private String _name;
    private String _description;
    private BaseModel<?> _contactGroupRemoteModel;

    public ContactGroupClp() {
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
    public long getPrimaryKey() {
        return _contactGroupId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setContactGroupId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _contactGroupId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getContactGroupId() {
        return _contactGroupId;
    }

    @Override
    public void setContactGroupId(long contactGroupId) {
        _contactGroupId = contactGroupId;

        if (_contactGroupRemoteModel != null) {
            try {
                Class<?> clazz = _contactGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setContactGroupId", long.class);

                method.invoke(_contactGroupRemoteModel, contactGroupId);
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

        if (_contactGroupRemoteModel != null) {
            try {
                Class<?> clazz = _contactGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_contactGroupRemoteModel, companyId);
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

        if (_contactGroupRemoteModel != null) {
            try {
                Class<?> clazz = _contactGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_contactGroupRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_contactGroupRemoteModel != null) {
            try {
                Class<?> clazz = _contactGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_contactGroupRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_contactGroupRemoteModel != null) {
            try {
                Class<?> clazz = _contactGroupRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_contactGroupRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getContactGroupRemoteModel() {
        return _contactGroupRemoteModel;
    }

    public void setContactGroupRemoteModel(BaseModel<?> contactGroupRemoteModel) {
        _contactGroupRemoteModel = contactGroupRemoteModel;
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

        Class<?> remoteModelClass = _contactGroupRemoteModel.getClass();

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

        Object returnValue = method.invoke(_contactGroupRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContactGroupLocalServiceUtil.addContactGroup(this);
        } else {
            ContactGroupLocalServiceUtil.updateContactGroup(this);
        }
    }

    @Override
    public ContactGroup toEscapedModel() {
        return (ContactGroup) ProxyUtil.newProxyInstance(ContactGroup.class.getClassLoader(),
            new Class[] { ContactGroup.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContactGroupClp clone = new ContactGroupClp();

        clone.setContactGroupId(getContactGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setName(getName());
        clone.setDescription(getDescription());

        return clone;
    }

    @Override
    public int compareTo(ContactGroup contactGroup) {
        long primaryKey = contactGroup.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactGroupClp)) {
            return false;
        }

        ContactGroupClp contactGroup = (ContactGroupClp) obj;

        long primaryKey = contactGroup.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{contactGroupId=");
        sb.append(getContactGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("biz.fz5.app.kumquat.model.ContactGroup");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contactGroupId</column-name><column-value><![CDATA[");
        sb.append(getContactGroupId());
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
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
