<%@include file="../init.jsp" %>

<% if(themeDisplay.isSignedIn()) { %>

<div class="wall_form_main">
	
	<portlet:actionURL var="startThreadURL">
		<portlet:param name="myAction" value="startThread" />
	</portlet:actionURL>
	
	<form name="<portlet:namespace />startThread" id="<portlet:namespace />startThread" 
			method="post" enctype="multipart/form-data" action="<%=startThreadURL.toString()%>" onmouseover="<portlet:namespace />clearEditor()">

	
	<input type="hidden" name="startThreadRedirect" id="startThreadRedirect" value="<%=defaultRenderURL.toString()%>" />
	
	<div class="message_form">
		<p class="em_title"><liferay-ui:message key="label.new.message" /></p>
                   
        <p class="form_label_text">
        	<strong><liferay-ui:message key="label.message" />:</strong><br/>
    		<!--  <em><liferay-ui:message key="msg.limit.message" /></em>-->
    	</p>
        <br/>
         
        <div>
			<%@include file="messageEditor.jsp" %>
        </div>
         
         <div class="wall_form_half_cont">
             <p class="form_label_text inputshort">
             	<strong><liferay-ui:message key="label.priority" />:<a class="help_icon tooltip" href="javascript:return false;"><img src="<%=themeDisplay.getPathThemeImages()%>/help_icon.png" alt="help" title="help"/><span class="classic"><liferay-ui:message key="msg.high.priority" /></span></a> </strong>
             	<br/>
              <select name="msgPriority" id="msgPriority" class="wall_form_priority form_item inputshort">
              	<option value="1.0"><liferay-ui:message key="msg.normal" /></option>
              	<option value="3.0"><liferay-ui:message key="msg.urgent" /></option>
              </select>
             </p>
         </div>
                    
        <div class="clear"></div>
	</div><!--ends message_form-->
    
    <div class="clear"></div>
        
	<%@include file="attachment.jsp" %>
	
    <div class="clear"></div>    
        
	<div class="button_container">
       <!-- <div class="grey_button"><a href="#" class="cancel_message">Cancel</a><span></span></div> -->
		<div>
			<input type="button" value='<liferay-ui:message key="label.start.new" />' onclick='<portlet:namespace />extractCodeFromEditor()' />
       		<span></span>
       </div>
	</div>
        
    <div class="clear"></div>
	
	
	</form>
	
</div>

<% } %>

<script type="text/javascript">
	function <portlet:namespace />clearEditor(){
		jQuery('#cke_<portlet:namespace />editor').find('iframe').contents().children('html').find('body').click(function(){
			var editorTxt = jQuery.trim(jQuery('#cke_<portlet:namespace />editor').find('iframe').contents().children('html').find('body').text());
			if(editorTxt == "(Type Your Message Here)"){
				jQuery('#cke_<portlet:namespace />editor').find('iframe').contents().children('html').find('body').html('<p>&nbsp;</p>');
			}
		});
	}
	function <portlet:namespace />extractCodeFromEditor(){
		var editorTxt = jQuery.trim(jQuery('#cke_<portlet:namespace />editor').find('iframe').contents().children('html').find('body').text());
		if((editorTxt == "(Type Your Message Here)") || (editorTxt == "")){
				alert("Please enter valid message!");
				return false;
		}else{
			jQuery('input[type="file"]').each(function() {
			        var id = jQuery(this).attr('id');
			        jQuery(this).attr('name',id);
		    });

			document.<portlet:namespace />startThread.myThreadBody.value = $('#cke_<portlet:namespace />editor').find('iframe').contents().children('html').find('body').html();
			submitForm(document.<portlet:namespace />startThread);
		}
	}
</script>
