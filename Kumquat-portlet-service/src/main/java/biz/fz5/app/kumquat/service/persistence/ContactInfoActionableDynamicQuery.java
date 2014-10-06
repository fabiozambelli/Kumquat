package biz.fz5.app.kumquat.service.persistence;

import biz.fz5.app.kumquat.model.ContactInfo;
import biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContactInfoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ContactInfoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ContactInfoLocalServiceUtil.getService());
        setClass(ContactInfo.class);

        setClassLoader(biz.fz5.app.kumquat.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("contactInfoId");
    }
}
