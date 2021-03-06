package biz.fz5.app.kumquat.model.impl;

import biz.fz5.app.kumquat.model.ContactGroup;
import biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ContactGroup service. Represents a row in the &quot;Kumquat_ContactGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactGroupImpl
 * @see biz.fz5.app.kumquat.model.ContactGroup
 * @generated
 */
public abstract class ContactGroupBaseImpl extends ContactGroupModelImpl
    implements ContactGroup {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a contact group model instance should use the {@link ContactGroup} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContactGroupLocalServiceUtil.addContactGroup(this);
        } else {
            ContactGroupLocalServiceUtil.updateContactGroup(this);
        }
    }
}
