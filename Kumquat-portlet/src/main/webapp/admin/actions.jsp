<%--
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
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="biz.fz5.app.kumquat.model.ContactInfo" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ContactInfo contactInfo = (ContactInfo)row.getObject();
String primKey = String.valueOf(contactInfo.getPrimaryKey());
%>

<liferay-ui:icon-menu>

<% if (permissionChecker.hasPermission(scopeGroupId,ContactInfo.class.getName(),primKey,"DELETE")) { %>
	<portlet:actionURL name="processRemove" var="deleteURL">
		<portlet:param name="primKey" value="<%=primKey %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>"/>
<% } %>

</liferay-ui:icon-menu>