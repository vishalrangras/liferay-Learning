<%@include file="/jsps/ihg/merlin/init.jsp" %>
<portlet:actionURL name="setMhnPreferences" var="setPreferencesURL" />
<portlet:renderURL var="backURL" portletMode="view"/>
<div class="mngPreference">
	<aui:form action="<%=setPreferencesURL%>" method="post"> 
		<aui:input type="text" name="prefTopContentId" label="Top content ID" value="${prefTopContentId}"></aui:input>
		<aui:input type="text" name="prefNoAccessToContentId" label="Error Content ID" value="${prefNoAccessToContentId}"></aui:input>
		<aui:input type="text" name="prefBottomContentId" label="Bottom content ID" value="${prefBottomContentId}"></aui:input>
		<aui:button-row>		
			<aui:button type="submit" value="Save"/>
			<aui:button value="Back" href="${backURL}" />
		</aui:button-row>
	</aui:form>
</div>