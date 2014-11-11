<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil" %>
<%@ page import="biz.fz5.app.kumquat.model.ContactGroup" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

long contactGroupId = -1;
ContactGroup contactGroup = null;
try {
	contactGroupId = Long.parseLong(preferences.getValue("contactGroupId",""));
	contactGroup = ContactGroupLocalServiceUtil.getContactGroup(contactGroupId);
} catch (Exception e) {}

    
%>

<% 
List<ContactGroup> contactGroups = null;
try {
	contactGroups = ContactGroupLocalServiceUtil.list(themeDisplay.getSiteGroupIdOrLiveGroupId(), themeDisplay.getCompanyId());
} catch (Exception e) {
	contactGroups = new ArrayList<ContactGroup>();
}
%>
<% if (contactGroups.size()==0) { %>
	<div class="alert"><liferay-ui:message key="alert-group-configuration" /></div>
	<div class="thumbnails"><img src="/Kumquat-portlet/img/help1.png"/></div>
<% } else { %>
	<liferay-ui:success key="contact-group-item-successfull" message="contact-group-item-successfull" />
	<p><liferay-ui:message key="help-configuration" /></p>
	<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
	<aui:form action="<%= configurationURL %>" method="post" name="fm">
		<aui:fieldset label="">		
			<aui:select bean="<%=contactGroup%>" name="contactGroupId">
				<% for (ContactGroup item : contactGroups) { %>
					<aui:option  value="<%=item.getPrimaryKey() %>"><%=item.getName() %></aui:option>
				<% } %>
			</aui:select>
			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>				
		</aui:fieldset>	
	</aui:form>
<% } %>