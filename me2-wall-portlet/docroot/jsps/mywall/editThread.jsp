<%@include file="../init.jsp" %>

<%
long editThreadId = 0l;
String editThreadBody = "";
String editThreadPriority = "";
if(Validator.isNotNull(request.getAttribute("editThreadId"))){
	editThreadId = Long.parseLong(request.getAttribute("editThreadId").toString());
	editThreadBody = (String)request.getAttribute("editThreadBody");
	editThreadPriority = String.valueOf(request.getAttribute("editThreadPriority"));
}
%>

<% if(themeDisplay.isSignedIn()) { %>

<div class="wall_form_main">
	
	<portlet:actionURL var="updateThreadURL">
		<portlet:param name="myAction" value="updateThread" />
	</portlet:actionURL>
	
	<form name="<portlet:namespace />editThread" id="<portlet:namespace />editThread" 
			method="post"  action="<%=updateThreadURL.toString()%>" onsubmit='<portlet:namespace />extractCodeFromEditor()'>
	
	
	<div class="message_form">
		<p class="em_title"><liferay-ui:message key="label.edit.message" /></p>
                    
        <p class="form_label_text">
        	<strong><liferay-ui:message key="label.message" />:</strong><br/>
    		<em><liferay-ui:message key="msg.limit.message" /></em>
    	</p>
        <input type="hidden" name="editThreadId" value="<%=editThreadId%>">
        <br/>
        <br/>
        <div>
        	<liferay-ui:input-editor toolbarSet="slimmed" width="550" height="180" />
			<input name="editThreadBody" type="hidden" value="" />
        </div>
        <br/>
         
         <div class="wall_form_half_cont">
             <p class="form_label_text inputshort">
             	<strong><liferay-ui:message key="label.priority" />:<a class="help_icon tooltip" href="javascript:return false;"><img src="<%=themeDisplay.getPathThemeImages()%>/help_icon.png" alt="help" title="help"/><span class="classic"><liferay-ui:message key="msg.high.priority" /></span></a> </strong>
             	<br/>
              <select name="editThreadPriority" id="editThreadPriority" class="wall_form_priority form_item inputshort">
              <%
              	if(editThreadPriority.equals("1.0")){
              %>
              	<option value="1.0" selected="selected"><liferay-ui:message key="msg.normal" /></option>
              	<option value="3.0"><liferay-ui:message key="msg.urgent" /></option>
              	<%
              	}else{
              	%>
              	<option value="1.0"><liferay-ui:message key="msg.normal" /></option>
              	<option value="3.0" selected="selected"><liferay-ui:message key="msg.urgent" /></option>
              	<%
              	}
              	%>
              </select>
             </p>
         </div>
                    
        <div class="clear"></div>
	</div><!--ends message_form-->
    
    <div class="clear"></div>
        
	<div class="button_container">
		<div>
			<input type="submit" value='Update' />
       		<span></span>
       </div>
	</div>
        
    <div class="clear"></div>
	
	
	</form>
	
</div>

<% } %>

<script type="text/javascript">
function <portlet:namespace />initEditor() {
	return "<%= UnicodeFormatter.toString(editThreadBody) %>";
}
function <portlet:namespace />extractCodeFromEditor(){
	document.<portlet:namespace />editThread.editThreadBody.value = window.<portlet:namespace />editor.getHTML();
	submitForm(document.<portlet:namespace />editThread);
}
</script>
