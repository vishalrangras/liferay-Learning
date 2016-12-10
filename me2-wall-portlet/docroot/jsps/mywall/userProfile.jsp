<%@include file="../init.jsp" %>

	
<div>

	<div class="user-info">
		<p class="float-container">
			<img src='<c:out value="${portraitUrl}" />' class="avatar" alt='<c:out value="${userFullName}" />'>
			<span><b><c:out value="${userFullName}" /></b></span> 
		</p>
	</div>	
	
	<!-- profile modal container -->
	<div class="modal_content_liquid">
	    <p><liferay-ui:message key="label.jobTitle" /> : <strong><c:out value="${jobTitle}" /></strong></p>
	    <p><liferay-ui:message key="label.reach" /> : <strong><c:out value="${emailAddress}" /></strong></p>
	    <p><liferay-ui:message key="label.dept" /> : <strong><c:out value="${strDept}" /></strong></p>
	    <p><liferay-ui:message key="label.locations" /> : <strong><c:out value="${strLocation}" /></strong></p>
	</div>

</div>	