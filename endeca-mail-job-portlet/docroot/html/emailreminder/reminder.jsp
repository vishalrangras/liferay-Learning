<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.ihg.me2.model.EmailReminder"%>

<link rel="stylesheet" href="/hs-theme/css/jquery.ui.all.css" type="text/css" />
<link rel="stylesheet" href="/hs-theme/css/form.css" type="text/css" />
<style>
.editor-label{
	display:inline !important;;
}
.editor-div {
    margin: .8em 0 0 .5em;
    clear: left;
    float:left;
    width: 160px;
}

.editor-label-em {
    color:#FF0000;
}

.editor-field {
    margin: .5em 0 0 0;
    float: left;
}

.field-validation-error {
    color: #FF0000;
    display: none;
}

.form_btn{
	clear: both;
}

.attach_filename {
    display:block;
}

</style>


<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/html/emailreminder/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="updateReminder" var="updateReminderURL"></portlet:actionURL>

<div>
<form action="<%= updateReminderURL %>" name="Reminder" id="Reminder" method="post" enctype="multipart/form-data">
<h1 class="shareidea_title">Schedule Email Reminder</h1>
<br></br>
<p class="solutionform_p_indent"><em class="solutionform_em">* </em>Required</p>

	<input type="hidden" name="emailReminderId" value="${emailReminder.emailReminderId}"/>
	<input type="hidden" name="operation" value="${operation}"/>
	<div class="editor-div">
		<em class="editor-label-em">* </em><label for="date" class="editor-label">Scheduled Date:</label>
	</div>
	<div class="editor-field">
		<input type="text" id="scheduleDate" name="scheduleDate" value="${scheduleDate}" autocomplete="off"/>
		<span class="field-validation-error" id="schedule-date-error">
			<span>This field is required</span>
		</span>
	</div>	
	 
	<div class="editor-div">
		<em class="editor-label-em">* </em><label for="type" class="editor-label">Type</label>
	</div>
	<div class="editor-field">
		<select id="type" name="type">
			<option value=""></option>
			<option value="1" ${emailReminder.reminderNumber == 1 ? 'selected=selected' : ''}>Reminder 1</option>
			<option value="2" ${emailReminder.reminderNumber == 2 ? 'selected=selected' : ''}>Reminder 2</option>
			<option value="3" ${emailReminder.reminderNumber == 3 ? 'selected=selected' : ''}>Reminder 3</option>
		</select>
		<span class="field-validation-error" id="type-error">
			<span>This field is required</span>
		</span>
	</div>
	<div class="editor-div">
		<em class="editor-label-em">* </em><label for="subject" class="editor-label">Subject</label>
	</div>
	<div class="editor-field">	
		<input type="text" id="subject" name="subject" value="${emailReminder.emailSubjectText}" autocomplete="off"/>
		<span class="field-validation-error" id="subject-error">
			<span>This field is required</span>
		</span>
	</div>
	<div class="editor-div">
		<em class="editor-label-em">* </em><label for="body" class="editor-label">Body</label>
	</div>
	<div class="editor-field">	
		<%-- <textarea  rows="4" cols="50" name="body" id="body">${emailReminder.emailBodyText}</textarea> --%>
		<liferay-ui:input-editor name="body" initMethod="initEditor" width="100" height="400" 
  			resizable="true" ></liferay-ui:input-editor>
  			
		<span class="field-validation-error" id="body-error">
			<span>This field is required</span>
		</span>
	</div>
	<div class="editor-div">
		<label for="attachment1">Attachment 1</label>
	</div>
	<div class="editor-field">
		<input type="file" name="attachment1" id="attachment1" />
		<span class="attach_filename">${fileName1}</span>
	</div>
	<div class="editor-div">
		<label for="attachment2">Attachment 2</label>
	</div>
	<div class="editor-field">
		<input type="file" name="attachment2" id="attachment2"/>
		<span class="attach_filename">${fileName2}</span>
	</div>
	<div class="editor-div">
		<label for="attachment3">Attachment 3</label>
	</div>
	<div class="editor-field">
		<input type="file" name="attachment3" id="attachment3"/>
		<span class="attach_filename">${fileName3}</span>
	</div>
	<div class="btn_section form_btn"> 
		<span class="fRight">
			<a id="Cancel_btn" class="gmaaccess_Submit_btn" href="<%= viewURL %>" title="Cancel">Cancel</a><span></span>
		</span>
		<span class="fRight">
			<a id="gmaaccess_Submit_btn" class="gmaaccess_Submit_btn" href="" title="Submit">Submit</a><span></span>
		</span>
	</div>
	<%-- <div>
		<input type="submit" value="Save" class="gmaaccess_Submit_btn"/>
		<input type="button" onclick="javascript: location.href='<%= viewURL %>';" value="Cancel"/>
	</div> --%>

</form>
</div>

<script type="text/javascript">
$(function() {
	$("#gmaaccess_Submit_btn").click(function(e){
		
		$('.field-validation-error').css("display","none");
		
		e.preventDefault(); //prevents default click behavior
		
		var date = $('#scheduleDate').val();
		var type = $('select#type option:checked').val();
		var subject = $('#subject').val();
		var body = $('#body').val();
		var msg = "";
		
		console.log("The entered values are: "+date+", "+type+", "+subject+", "+body);
		
		console.log("The click event occured as expected...");
		
		if(date==""){
			$('#schedule-date-error').css("display","inline-block");
		}
		
		if(type==""){
			$('#type-error').css("display","inline-block");
		}
		
		if(subject==""){
			$('#subject-error').css("display","inline-block");
		}
		
		if(body==""){
			$('#body-error').css("display","inline-block");
		}
		
		if (date!=""&&type!=""&&subject!=""&&body!=""){
			console.log("The form will be submitted with: "+date+", "+type+", "+subject+", "+body);
			$("form#Reminder").submit();
		}
		
	});
});
</script>

<script>
  $( function() {
    $( "#scheduleDate" ).datepicker();
  } );
</script>

<script type="text/javascript">
 function <portlet:namespace/>initEditor(){
 	<% 
 	
 		EmailReminder emailReminder = (EmailReminder)request.getAttribute("emailReminder");
 		String mailBody = StringPool.BLANK;
 		if(emailReminder!=null){
 			mailBody = emailReminder.getEmailBodyText();
 		}
 	%>
 	
 	var mailBody = '<%=UnicodeFormatter.toString(mailBody)%>';
 	console.log(mailBody);
 	return mailBody;
 	
 }
</script>