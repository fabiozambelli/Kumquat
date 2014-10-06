<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="biz.fz5.app.kumquat.model.ContactGroup" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<portlet:defineObjects />

<%
ContactGroup contactGroup = (ContactGroup)request.getAttribute("contactGroup");
String primKey = null;
String name = null;
String description = null;

if (Validator.isNotNull(contactGroup)) {
	primKey = String.valueOf(contactGroup.getPrimaryKey());
	name = contactGroup.getName();
	description = contactGroup.getDescription();
}
	
String actionName = (String)request.getAttribute("actionName");
%>

<portlet:actionURL name="<%=actionName%>" var="actionURL"/>
	
<aui:form name="fm" action="<%=actionURL.toString()%>" method="post">
	<aui:fieldset>
		<aui:input type="hidden" name="primKey" value="<%=primKey%>"/>
		<aui:input type="text" name="name" value="<%=name%>"/>					
		<liferay-ui:error key='groupname-error' message='<%=(String)SessionErrors.get(renderRequest,"groupname-error")%>'/>
		<aui:input type="text" name="description" value="<%=description%>"/>
		<aui:button-row>
			<aui:button type="submit"/>				
		</aui:button-row>
	</aui:fieldset>
</aui:form>