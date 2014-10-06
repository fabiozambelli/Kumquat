<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.Folder" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.NoSuchFolderException" %>

<%@ page import="biz.fz5.app.kumquat.service.ContactInfoLocalServiceUtil" %>
<%@ page import="biz.fz5.app.kumquat.service.ContactGroupLocalServiceUtil" %>
<%@ page import="biz.fz5.app.kumquat.model.ContactInfo" %>
<%@ page import="biz.fz5.app.kumquat.model.ContactGroup" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<portlet:defineObjects />

<liferay-theme:defineObjects/>

<% 
// utils
SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy HH:mm");

// portlet should be configured for rootFolderId
PortletPreferences preferences = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if (Validator.isNotNull(portletResource))
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);


long rootFolderId = 0;
String rootFolderName = null;
try {
	rootFolderId = Long.parseLong(preferences.getValue("rootFolderId",""));	
} catch (Exception e) {}
try {
	Folder rootFolder = DLAppLocalServiceUtil.getFolder(rootFolderId);
	rootFolderName = rootFolder.getName();
}
catch (NoSuchFolderException nsfe) {
	rootFolderName = "Home";
}

%>
<p><liferay-ui:message key="help-folder-configuration"/>"<%=rootFolderName %>"</p>
<% 
// contact group must be defined by user
long contactGroupId = -1L;
if (renderRequest.getAttribute("contactGroupId")!=null)
	contactGroupId = (Long)renderRequest.getAttribute("contactGroupId");

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
	<script>
	function updateReportView() {	
		submitForm(document.<portlet:namespace />contactGroup);
	}
	</script>
	<portlet:actionURL name="setGroup" var="setGroupActionURL"/>
	<aui:form action="<%=setGroupActionURL.toString()%>" method="post" name="contactGroup">
			<aui:select name="contactGroupId" onChange="javascript:updateReportView()">
				<aui:option value=""></aui:option>
				<% for (ContactGroup item : contactGroups) { %>
					<aui:option  value="<%=item.getPrimaryKey() %>" selected="<%=(contactGroupId==item.getPrimaryKey())?true:false %>"><%=item.getName() %></aui:option>
				<% } %>
			</aui:select>					
	</aui:form>
<% } %>	
				
<% 
// if a contact group is defined the report can be perfomed
if (contactGroupId>-1) {
	// retrive the contact
	List<ContactInfo> cnts = null;
	try {
		cnts = ContactInfoLocalServiceUtil.list(contactGroupId, themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId());
	} catch (Exception e) {
		cnts = new ArrayList<ContactInfo>();
	}

	// if there is some contact
	if ((cnts!=null)&&(cnts.size()>0)) { 

		String reportURL = null;
		reportURL = (String)renderRequest.getAttribute("download-contact-info-report");	
		
		// if the file report is perfomed
		if (reportURL!=null)  { 
			%>	
				<liferay-ui:icon
					image="download"
					label="<%= true %>"
					message='download-report'
					url="<%= reportURL %>"
				/>			
		<% } %>
		<portlet:actionURL name="export" var="exportActionURL"/>
		<aui:form name="fm" action="<%=exportActionURL.toString()%>" method="post">
			<aui:input type="hidden" name="rootFolderId" value="<%=rootFolderId%>"/>
			<aui:input type="hidden" name="contactGroupId" value="<%=contactGroupId%>"/>		
				<aui:button-row>
					<aui:button type="submit" value="contact-report-submit"/>				
				</aui:button-row>		
		</aui:form>
		<p class="text-center"><em>items found : <%=cnts.size() %></em></p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><liferay-ui:message key="contact-report-table-column-date" /></th>
					<th><liferay-ui:message key="contact-report-table-column-lastname" /></th>
					<th><liferay-ui:message key="contact-report-table-column-firstname" /></th>			
					<th><liferay-ui:message key="contact-report-table-column-email" /></th>
					<th><liferay-ui:message key="contact-report-table-column-phone" /></th>
				</tr>
			</thead>
			<tbody>
		<%
		for (ContactInfo cnt : cnts) {
		%>
				<tr>
					<td><%=dateFormat.format(cnt.getCreateDate())%></td>
					<td><%=cnt.getLastName()%></td>
					<td><%=cnt.getFirstName()%></td>			
					<td><%=cnt.getEmailAddress()%></td>
					<td><%=cnt.getTelephoneNumber()%></td>
				</tr>
		<%	
		}
		%>
			</tbody>
		</table>

	<% } else {  // if there is some contact %>
	<p class="text-center"><em>no items found</em></p>
	<% } %>

<% } // if a contact group is defined the report can be perfomed %>