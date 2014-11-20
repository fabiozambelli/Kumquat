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

<%@ page import="biz.fz5.app.kumquat.search.ContactInfoSearch" %>
<%@ page import="biz.fz5.app.kumquat.search.ContactInfoSearchTerms" %>
<%@ page import="biz.fz5.app.kumquat.search.ContactInfoDisplayTerms" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.portlet.PortletURL" %>

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
if (renderRequest.getAttribute("contactGroupId")!=null) {
	contactGroupId = (Long)renderRequest.getAttribute("contactGroupId");
	renderRequest.getPortletSession().setAttribute("contactGroupId", contactGroupId);
} else if (renderRequest.getPortletSession().getAttribute("contactGroupId")!=null) {
	contactGroupId = (Long)renderRequest.getPortletSession().getAttribute("contactGroupId");
}

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
		
		<%
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("mvc", "/admin/view.jsp");
		pageContext.setAttribute("portletURL", portletURL);
		%>

		<liferay-ui:search-container searchContainer="<%= new ContactInfoSearch(renderRequest, portletDisplay.getId(), portletURL)%>">
	
			<%			
			ContactInfoSearchTerms searchTerms = (ContactInfoSearchTerms)searchContainer.getSearchTerms();	
			ContactInfoDisplayTerms displayTerms = (ContactInfoDisplayTerms)searchContainer.getDisplayTerms();
			
			String lastName = null;
			if ( (searchTerms.getKeywords()!=null)&&(!"".equals(searchTerms.getKeywords())) )
				lastName = searchTerms.getKeywords();
			else 
				lastName = searchTerms.getLastName();
			
			String emailAddress = null;
			if ( (searchTerms.getKeywords()!=null)&&(!"".equals(searchTerms.getKeywords())) )
				emailAddress = searchTerms.getKeywords();
			else 
				emailAddress = searchTerms.getEmailAddress();			
			List<ContactInfo> contacts = ContactInfoLocalServiceUtil.search(themeDisplay.getCompanyId(), themeDisplay.getSiteGroupIdOrLiveGroupId(), contactGroupId, lastName, emailAddress, searchTerms.isAndOperator(), searchContainer.getOrderByComparator());
			%>
		
			<liferay-ui:search-container-results results="<%=contacts %>" total="<%=contacts.size() %>" />						
				
			<liferay-ui:search-container-row className="biz.fz5.app.kumquat.model.ContactInfo"
				keyProperty="contactInfoId"
				modelVar="contactInfo">
				<portlet:renderURL var="rowURL">				
					<portlet:param name="resourcePrimKey" value="<%= String.valueOf(contactInfo.getPrimaryKey()) %>"/>
					<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
				</portlet:renderURL>
				<liferay-ui:search-container-column-text name="create-date" value="<%=dateFormat.format(contactInfo.getCreateDate())%>"/>
				<liferay-ui:search-container-column-text name="last-name" orderable="<%= true %>" property="lastName"/>
				<liferay-ui:search-container-column-text name="first-name" property="firstName"/>
				<liferay-ui:search-container-column-text name="email-address" orderable="<%= true %>" property="emailAddress"/>
				<liferay-ui:search-container-column-text name="telephone-number" property="telephoneNumber"/>			
			</liferay-ui:search-container-row>
		
			<liferay-ui:search-iterator/>
			
		</liferay-ui:search-container>	
		
	
		

	<% } else {  // if there is some contact %>
	<p class="text-center"><em>no items found</em></p>
	<% } %>

<% } // if a contact group is defined the report can be perfomed %>