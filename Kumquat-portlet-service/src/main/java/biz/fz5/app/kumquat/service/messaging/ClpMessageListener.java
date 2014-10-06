package biz.fz5.app.kumquat.service.messaging;

import biz.fz5.app.kumquat.service.ClpSerializer;
import biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil;
import biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ContactGroupLocalServiceUtil.clearService();

            ContactInfoLocalServiceUtil.clearService();
        }
    }
}
