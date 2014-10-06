package biz.fz5.app.kumquat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContactInfoSoap implements Serializable {
    private long _contactInfoId;
    private long _companyId;
    private long _groupId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _firstName;
    private String _lastName;
    private String _telephoneNumber;
    private String _emailAddress;
    private boolean _agreedToPrivacy;
    private long _contactGroupId;

    public ContactInfoSoap() {
    }

    public static ContactInfoSoap toSoapModel(ContactInfo model) {
        ContactInfoSoap soapModel = new ContactInfoSoap();

        soapModel.setContactInfoId(model.getContactInfoId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setLastName(model.getLastName());
        soapModel.setTelephoneNumber(model.getTelephoneNumber());
        soapModel.setEmailAddress(model.getEmailAddress());
        soapModel.setAgreedToPrivacy(model.getAgreedToPrivacy());
        soapModel.setContactGroupId(model.getContactGroupId());

        return soapModel;
    }

    public static ContactInfoSoap[] toSoapModels(ContactInfo[] models) {
        ContactInfoSoap[] soapModels = new ContactInfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContactInfoSoap[][] toSoapModels(ContactInfo[][] models) {
        ContactInfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContactInfoSoap[models.length][models[0].length];
        } else {
            soapModels = new ContactInfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContactInfoSoap[] toSoapModels(List<ContactInfo> models) {
        List<ContactInfoSoap> soapModels = new ArrayList<ContactInfoSoap>(models.size());

        for (ContactInfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContactInfoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contactInfoId;
    }

    public void setPrimaryKey(long pk) {
        setContactInfoId(pk);
    }

    public long getContactInfoId() {
        return _contactInfoId;
    }

    public void setContactInfoId(long contactInfoId) {
        _contactInfoId = contactInfoId;
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

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getTelephoneNumber() {
        return _telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        _telephoneNumber = telephoneNumber;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;
    }

    public boolean getAgreedToPrivacy() {
        return _agreedToPrivacy;
    }

    public boolean isAgreedToPrivacy() {
        return _agreedToPrivacy;
    }

    public void setAgreedToPrivacy(boolean agreedToPrivacy) {
        _agreedToPrivacy = agreedToPrivacy;
    }

    public long getContactGroupId() {
        return _contactGroupId;
    }

    public void setContactGroupId(long contactGroupId) {
        _contactGroupId = contactGroupId;
    }
}
