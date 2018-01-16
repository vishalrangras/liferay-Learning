<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:renderURL var="addRenderURL">
    <portlet:param name="mvcPath" value="/html/emailreminder/reminder.jsp"></portlet:param>
    <portlet:param name="cmd" value="create"></portlet:param>
</portlet:renderURL>

<div>
	<a href="<%=addRenderURL%>">Add</a>
</div>

<div>
	<table>
		<tr>
			<th>ID</th>
			<th>Submitter Name</th>
			<th>Submitter Email</th>
			<th>Subject</th>
			<th>Type</th>
			<th>Scheduled Date</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${emailReminderList}" var="emailReminder"
			varStatus="loop">
			<tr>
				<td>${loop.index+1}</td>
				<td>${emailReminder.submitterName}</td>
				<td>${emailReminder.submitterEmailId}</td>
				<td>${emailReminder.emailSubjectText}</td>
				<td>Reminder ${emailReminder.reminderNumber}</td>
				<td><fmt:formatDate value="${emailReminder.scheduleTimestamp}" pattern="MM-dd-yyyy" /></td>
				<td>${emailReminder.statusCode == 1 ? 'Pending' : 'Completed'}</td>
				
				<portlet:renderURL var="editReminderURL">
					<portlet:param name="mvcPath"
						value="/html/emailreminder/reminder.jsp"></portlet:param>
					<portlet:param name="cmd" value="edit"></portlet:param>
					<portlet:param name="emailReminderId" value="${emailReminder.emailReminderId}"></portlet:param>
				</portlet:renderURL>
				
				<portlet:actionURL name="deleteReminder" var="deleteReminderURL">
					<portlet:param name="emailReminderId" value="${emailReminder.emailReminderId}"></portlet:param>
				</portlet:actionURL>
				
				<td><a href="<%= editReminderURL %>">Edit</a> | <a href="<%=deleteReminderURL%>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>