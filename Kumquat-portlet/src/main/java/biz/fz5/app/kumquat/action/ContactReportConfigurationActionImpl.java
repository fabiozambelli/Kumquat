package biz.fz5.app.kumquat.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.ValidatorException;

/**
 * @author Fabio Zambelli
 *
 */
public class ContactReportConfigurationActionImpl extends
		DefaultConfigurationAction {

	private static final Log _log = LogFactoryUtil
			.getLog(ContactReportConfigurationActionImpl.class);

	/**
	 * Set the root folder in which the xls will be exported
	 */
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String rootFolderId = ParamUtil.getString(actionRequest,
				"rootFolderId", StringPool.BLANK);

		_log.debug("rootFolderId:" + rootFolderId);

		if ((rootFolderId != null) && (!"".equals(rootFolderId))) {

			String portletResource = ParamUtil.getString(actionRequest,
					"portletResource");
			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest, portletResource);

			preferences.setValue("rootFolderId", rootFolderId);
			preferences.setValue("portletResource", portletResource);

			try {
				preferences.store();
			} catch (ValidatorException ve) {

				SessionErrors.add(actionRequest,
						ValidatorException.class.getName(), ve);

			}

			SessionMessages.add(actionRequest, "root-folder-id-successfull");
			
			SessionMessages.add(actionRequest, portletConfig.getPortletName()
                    + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
                    portletResource);					

		} else {
			SessionErrors.add(actionRequest, "root-folder-id-default");
		}
			

	}
}
