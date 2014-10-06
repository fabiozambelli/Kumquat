<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ page import="biz.fz5.app.kumquat.model.ContactInfo" %>
<%@ page import="biz.fz5.app.kumquat.model.impl.ContactInfoImpl" %>
<%@ page import="biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil" %>
<%@ page import="biz.fz5.app.kumquat.model.ContactGroup" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<portlet:defineObjects />

<liferay-theme:defineObjects/>

<%
ContactInfo cntct = null;
cntct =  (ContactInfo) request.getAttribute("contact");
if (cntct==null) {
	cntct= new ContactInfoImpl();
}
%>

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

long contactGroupId = -1;

try {
	contactGroupId = Long.parseLong(preferences.getValue("contactGroupId",""));	
} catch (Exception e) {}

    
%>


<portlet:actionURL name="processAdd" var="actionURL"/>

<div class="box-contact">
	<aui:form name="fm" action="<%=actionURL.toString()%>" method="post">
		<liferay-ui:success key="contact-saved-successfully" message="contact-saved-successfully" />
		<liferay-ui:error key='contact-already-exists' message='<%=(String)SessionErrors.get(renderRequest,"contact-already-exists")%>'/>
		<liferay-ui:error key='contact-group-id-error' message='<%=(String)SessionErrors.get(renderRequest,"contact-group-id-error")%>'/>
		<aui:input type="hidden" name="contactGroupId" value="<%=contactGroupId%>"/>
		<liferay-ui:error key='firstname-error' message='<%=(String)SessionErrors.get(renderRequest,"firstname-error")%>'/>
		<aui:input type="text" name="firstName" value="<%=cntct.getFirstName()%>"/>			
		<liferay-ui:error key='lastname-error' message='<%=(String)SessionErrors.get(renderRequest,"lastname-error")%>'/>
		<aui:input type="text" name="lastName" value="<%=cntct.getLastName()%>"/>
		<liferay-ui:error key='email-error' message='<%=(String)SessionErrors.get(renderRequest,"email-error")%>'/>
		<aui:input type="text" name="emailAddress" value="<%=cntct.getEmailAddress()%>"/>
		<liferay-ui:error key='telephone-error' message='<%=(String)SessionErrors.get(renderRequest,"telephone-error")%>'/>
		<aui:input type="text" name="telephoneNumber" value="<%=cntct.getTelephoneNumber()%>"/>
		<liferay-ui:error key='agreement-error' message='<%=(String)SessionErrors.get(renderRequest,"agreement-error")%>'/>
		<aui:input type="checkbox" name="agreedToPrivacy" value="<%=cntct.getAgreedToPrivacy()%>"/>
		<aui:button-row>
			<aui:button type="submit" class="btn-small" value="send-contact"/>				
		</aui:button-row>
	</aui:form>
</div>