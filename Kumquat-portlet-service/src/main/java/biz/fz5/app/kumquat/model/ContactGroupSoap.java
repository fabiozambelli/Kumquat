package biz.fz5.app.kumquat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactGroupSoap implements Serializable {
    private long _contactGroupId;
    private long _companyId;
    private long _groupId;
    private String _name;
    private String _description;

    public ContactGroupSoap() {
    }

    public static ContactGroupSoap toSoapModel(ContactGroup model) {
        ContactGroupSoap soapModel = new ContactGroupSoap();

        soapModel.setContactGroupId(model.getContactGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static ContactGroupSoap[] toSoapModels(ContactGroup[] models) {
        ContactGroupSoap[] soapModels = new ContactGroupSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContactGroupSoap[][] toSoapModels(ContactGroup[][] models) {
        ContactGroupSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContactGroupSoap[models.length][models[0].length];
        } else {
            soapModels = new ContactGroupSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContactGroupSoap[] toSoapModels(List<ContactGroup> models) {
        List<ContactGroupSoap> soapModels = new ArrayList<ContactGroupSoap>(models.size());

        for (ContactGroup model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContactGroupSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contactGroupId;
    }

    public void setPrimaryKey(long pk) {
        setContactGroupId(pk);
    }

    public long getContactGroupId() {
        return _contactGroupId;
    }

    public void setContactGroupId(long contactGroupId) {
        _contactGroupId = contactGroupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
