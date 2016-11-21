<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@include file="/html/init.jsp"%>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/guestbook/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addEntry " var="addEntryURL"></portlet:actionURL>

<%
	long entryId = ParamUtil.getLong(renderRequest, "entryId");

	Entry entry = null;

	if (entryId > 0) {

		entry = EntryLocalServiceUtil.getEntry(entryId);

	}

	long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");
%>

<aui:form action="<%=addEntryURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=entry%>" model="<%=Entry.class%>" />

	<aui:fieldset>

		<aui:input name="name" />
		<aui:input name="email" />
		<aui:input name="message" />
		<aui:input name='guestbookId' type='hidden'
			value='<%=ParamUtil.getString(renderRequest, "guestbookId")%>' />
		<aui:input name="entryId" type="hidden" />
		
		<aui:input name="guestbookId" type="hidden" value='<%= entry == null ? guestbookId : entry.getGuestbookId() %>'/>
	
	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button onClick="<%=viewURL.toString()%>" type="cancel"></aui:button>

	</aui:button-row>

</aui:form>