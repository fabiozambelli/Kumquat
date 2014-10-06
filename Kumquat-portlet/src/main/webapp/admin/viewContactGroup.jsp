<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil" %>
<%@ page import="biz.fz5.app.kumquat.model.ContactGroup" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<portlet:defineObjects />

<liferay-theme:defineObjects/>


<liferay-ui:icon-menu>

	<portlet:actionURL name="prepareAdd" var="addContactGroupURL" />
			
	<liferay-ui:icon image="add" message="add-contact-group" url="<%=addContactGroupURL%>"></liferay-ui:icon>				
	
</liferay-ui:icon-menu>


<%
List<ContactGroup> list = null;

try {
	list = ContactGroupLocalServiceUtil.list(themeDisplay.getSiteGroupIdOrLiveGroupId(), themeDisplay.getCompanyId());
} catch (Exception e) {  	
	list = new ArrayList<ContactGroup>();
}
%>
<liferay-ui:success key="contact-group-item-successfull" message="contact-group-item-successfull" />
<liferay-ui:error key='contact-exists-for-group-id' message='<%=(String)SessionErrors.get(renderRequest,"contact-exists-for-group-id")%>'/>

<table class="table table-striped">
	<thead>
		<tr>
			<th><liferay-ui:message key="contact-group-table-column-name" /></th>
			<th><liferay-ui:message key="contact-group-table-column-description" /></th>
			<th></th>								
		</tr>
	</thead>
	<tbody>
<%
for (ContactGroup contactGroup : list) {
%>
		<tr>			
			<td><%=contactGroup.getName()%></td>			
			<td><%=contactGroup.getDescription()%></td>
			<td>				
				<liferay-ui:icon-menu>

				    <portlet:actionURL name="prepareModify" var="editURL">    
						<portlet:param name="primKey" value="<%=Long.toString(contactGroup.getPrimaryKey()) %>"/>
					</portlet:actionURL>
					<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>"/>
					<portlet:actionURL name="processRemove" var="deleteURL">
						<portlet:param name="primKey" value="<%=Long.toString(contactGroup.getPrimaryKey()) %>"/>
					</portlet:actionURL>
					<liferay-ui:icon-delete url="<%=deleteURL.toString() %>"/>
				
				</liferay-ui:icon-menu>
			</td>			
		</tr>
<%	
}
%>
	</tbody>
</table>