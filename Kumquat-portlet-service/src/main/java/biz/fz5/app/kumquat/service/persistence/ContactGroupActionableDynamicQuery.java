package biz.fz5.app.kumquat.service.persistence;

import biz.fz5.app.kumquat.model.ContactGroup;
import biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContactGroupActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ContactGroupActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ContactGroupLocalServiceUtil.getService());
        setClass(ContactGroup.class);

        setClassLoader(biz.fz5.app.kumquat.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("contactGroupId");
    }
}
