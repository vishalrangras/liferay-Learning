<%@include file="../init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.ihg.mss.portal.util.CommonUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="com.liferay.portal.kernel.util.FileUtil"%>
<%@ page import="com.ihg.me2.portlet.util.WallPortletUtil" %>

<form name="<portlet:namespace />wallPosts" id="<portlet:namespace />wallPosts" method="post">

	<portlet:actionURL var="postReplyURL">
		<portlet:param name="myAction" value="postComments" />
	</portlet:actionURL>

	<portlet:actionURL var="deleteThreadURL">
		<portlet:param name="myAction" value="deleteThread" />
	</portlet:actionURL>

	<portlet:resourceURL var="showLikersURL"></portlet:resourceURL>
	
	<portlet:resourceURL var="showUserProfileURL">
		<portlet:param name="myAction" value="showUserProfile" />
	</portlet:resourceURL>
	
	<portlet:actionURL var="deleteMessageURL">
		<portlet:param name="myAction" value="deleteMessage" />
	</portlet:actionURL>
	
	<portlet:actionURL var="saveMessageURL">
		<portlet:param name="myAction" value="saveMessage" />
	</portlet:actionURL>
	
	<portlet:actionURL var="editThreadURL">
		<portlet:param name="myAction" value="editThread" />
	</portlet:actionURL>
	
	<input type="hidden" name="wallPostsRedirect" id="wallPostsRedirect" value="<%=defaultRenderURL.toString()%>" />
	<input type="hidden" id="categoryThreadParentMessageId" name="categoryThreadParentMessageId" />
	<input type="hidden" id="hiddenComments" name="hiddenComments" />


<div id="tabs_cont">
      <div class="tab_header">
          <ul>
              <li class="current"><a href="#all"><liferay-ui:message key="label.view.all" /></a></li>
          </ul>
      </div><!--ends tab_header -->
      <div class="clear"></div>
      
      <div id="all" class="tabs_content"> <!-- begin tab 1 -->
      
	<% 	
		if( request.getAttribute("messageBoardsDisplayList") != null && !((List<MBMessageDisplay>)request.getAttribute("messageBoardsDisplayList")).isEmpty())
		{
			List<MBMessageDisplay> listMessageDisplay = (List<MBMessageDisplay>)request.getAttribute("messageBoardsDisplayList");
			
			long companyId = themeDisplay.getCompanyId();
			boolean isMBMessageHavingEvent = Boolean.FALSE;
			List<MBMessage> listMessages = null;
			User rootPoster = null;
			User poster = null;
			User loggedInUser = themeDisplay.getUser();
			MBMessage rootMessage = null;
			MBThread mbThread = null;
			String location = "";
			int ctr = 0;
			
			for(MBMessageDisplay msgDisplay : listMessageDisplay)
			{
				rootMessage = WallPortletUtil.getMessage(msgDisplay.getThread().getRootMessageId());
				mbThread = msgDisplay.getThread();
				rootPoster = WallPortletUtil.getUser(rootMessage.getUserId());
				listMessages = msgDisplay.getTreeWalker().getMessages();
				
	%>
				
			<% if(ctr == 0 && rootMessage.getPriority() == 3.0 ) { %>
			<div class="item_important_container first_item">
			<% } else if(ctr == 0 && rootMessage.getPriority() != 3.0 ) { %>
			<div class="item_container first_item">
			<% } else if(ctr != 0 && rootMessage.getPriority() == 3.0 ) { %>
			<div class="item_important_container">
			<% } else { %>
			<div class="item_container">
			<% } %>
				
				<div class="item_inner_container">
						<% if(ctr != 0) { %><img src="<%=themeDisplay.getPathThemeImages()%>/item_shadow.png" class="item_shadow" alt="item shadow" /> <% } %>
						
		              <div class="item_left_col">
		                  <a href="javascript:showUserProfile('<%=showUserProfileURL%>', <%=rootPoster.getUserId()%>)" ><img height="42" width="41" alt="<%= HtmlUtil.escape(rootPoster.getFullName()) %>" class="profile_pic"  src="<%= rootPoster.getPortraitURL(themeDisplay) %>" /></a>
		                  <br/>
		                  <% if(rootMessage.getPriority() == 3.0) { %>
		                  <img class="notice_ribbon" src="<%=themeDisplay.getPathThemeImages()%>/notice_ribbon.png" alt="notice" title="notice" />
		                  <% } %>
		                  
		                  <%
		                  		boolean hasDeletePermission = Boolean.FALSE;
		                  
		                  		hasDeletePermission = permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), MBMessage.class.getName(), 
		                  				mbThread.getRootMessageId(), ActionKeys.DELETE);
		                  		
		                  		if(hasDeletePermission){
		                  %>
		                  <a class="util" href=""><img src="<%=themeDisplay.getPathThemeImages()%>/util_btn.png" alt="utility" title="utility"/></a>
		                  <div class="util_dropdown">
		                      <!-- <a href=""><div class="util_edit"><liferay-ui:message key="action.EDIT" /></div></a> -->
		                      <a href="javascript:editThread('<%=rootMessage.getThreadId()%>')">
		                      	<div class="util_delete"><liferay-ui:message key="action.EDIT" /></div>
		                      </a>
		                      <a href="javascript:deleteThread('<portlet:namespace />', '<%=deleteThreadURL.toString()%>', '<%=rootMessage.getThreadId()%>')">
		                      	<div class="util_delete"><liferay-ui:message key="action.DELETE" /></div>
		                      </a>
		                  </div>
		                  <%	
		                  		}
		                  %>
		                  
		              </div>
		                
		              <div class="item_right_col">
		                  <p class="item_name">
							<strong class="notranslate"><a href="javascript:showUserProfile('<%=showUserProfileURL%>', <%=rootPoster.getUserId()%>)" ><%= HtmlUtil.escape(rootPoster.getFullName()) %></a>
							</strong>
		                    <span class="span_mini_space">&nbsp;</span>
		                    <br/>
		                    <em>
		                    	<liferay-ui:message key="msg.posted" /> 
		                    	
		                    	<% 
		                    		String timeZoneId = timeZone.getID();		                    		
		                    		if(timeZoneId.equalsIgnoreCase(PropsUtil.get("ihg.timezone.utc"))){		                    			
		                    	%>
		                    			<%= WallPortletUtil.getFormattedDate(rootMessage.getCreateDate(), locale, timeZone) %>&nbsp;<%=PropsUtil.get("ihg.timezone.gmt")%>
		                    	<%
		                    		} else { %>
		                    			<%= WallPortletUtil.getFormattedDateWithTimeZone(rootMessage.getCreateDate(), locale, timeZone) %>
		                    	<% }
								%>
		                    </em>
		                    <br/>
		                    <span class="user_details_brand"><%= CommonUtil.getPeopleDBAttributeValue(companyId, rootPoster.getScreenName(), CommonUtil.PEOPLE_DB_ATTRIBUTE_NAME_BRAND)%></span>
		                    <span class="user_details_city"><%= CommonUtil.getPeopleDBAttributeValue(companyId, rootPoster.getScreenName(), CommonUtil.PEOPLE_DB_ATTRIBUTE_NAME_CITY)%></span> 							  
		                  </p>
		                  <div class="thumb_container">
		                      		<p>
		                      			<liferay-ui:ratings
											className="<%= MBMessage.class.getName() %>"
											classPK="<%= rootMessage.getMessageId() %>"
											type="thumbs" />
										<a class="likers" href="javascript:showLikers('<%=showLikersURL%>', '<%=rootMessage.getMessageId()%>')">Likers</a>	
									</p>
									
									<c:choose>
										
										<c:when test="<%= (threadSubscriptionClassPKs != null) && threadSubscriptionClassPKs.contains(rootMessage.getThreadId()) %>">
											<portlet:actionURL var="unsubscribeThreadURL">
												<portlet:param name="myAction" value="unsubscribeThread" />
												<portlet:param name="messageId" value="<%= String.valueOf(rootMessage.getMessageId()) %>" />
											</portlet:actionURL>
											
											<div class="subs-tooltip-container">
  												<a class="subs gray" href="<%=unsubscribeThreadURL.toString() %>">Unsubscribe</a>
                         						<span class="subs-tooltip-unsubscribe">Click unsubscribe to stop receiving updates when another user shares an update on this post
													<span class="arr-tooltip"></span>
												</span>
                							</div>
					
										</c:when>
										
										<c:otherwise>
											<portlet:actionURL var="subscribeThreadURL">
												<portlet:param name="myAction" value="subscribeThread" />
												<portlet:param name="messageId" value="<%= String.valueOf(rootMessage.getMessageId()) %>" />
											</portlet:actionURL>
											
											<div class="subs-tooltip-container">
  												<a class="subs" href="<%=subscribeThreadURL.toString() %>">Subscribe</a>
                        						<span class="subs-tooltip">Click subscribe to receive updates when another user shares an update on this post
                        							<span class="arr-tooltip"></span>
                        						</span>
                							</div>
											
										</c:otherwise>
										
									</c:choose>
									
									
									
							</div>
							<div class="clear"></div>
		                  	<div class="divider">&nbsp;</div>
		                  	<p class="item_body_text">
								
								<%=HtmlUtil.unescape( StringUtil.replace(rootMessage.getBody(true), "@theme_images_path@/emoticons", themeDisplay.getPathThemeImages() + "/emoticons") )%>
		                  	</p>
		                  
		                  	<!-- Attachments -->
		                  	<%  
		                  		List<FileEntry> attachments = WallPortletUtil.getMBMessageAttachments(rootMessage);
		                  	
								if(attachments != null && attachments.size() > 0){
		                  	%>
		                  	<ul class="item_attachments">
		                  	<%
		                  			for (FileEntry fileEntry : attachments) 
		                  			{
										String existingName = fileEntry.getTitle();
		    							String extention = FileUtil.getExtension(existingName);
		    							String pathThemeDisplay =  themeDisplay.getPathThemeImages();
		    							String filTypeImgPath = WallPortletUtil.getFileIconPath(themeDisplay.getPathThemeImages(), extention);
		    							StringBuilder builder = new StringBuilder(100);
		    							builder.append("/documents/portlet_file_entry/");
		    							builder.append(fileEntry.getGroupId()).append("/").append(fileEntry.getTitle()).append("/").append(fileEntry.getUuid());
		    							String fileUrl = builder.toString();
 
		                  	%>
			                  	 <li><img title="<%=extention%>" src="<%=filTypeImgPath%>" class="attachment_icon" />
									<a href='<%= fileUrl %>' ><%= existingName %></a>
								 </li>								
								<!--  <li><img title="video" alt="video" src="/video_icon.png" class="attachment_icon"><a href="" class="altcolor">Watch Video</a></li> -->
							
		                  	<%  } %>
		                  </ul>
		                  <% } %>
						<img src="<%=themeDisplay.getPathThemeImages()%>/comment_arrow.gif" class="comment_arrow" alt="comment_arrow" />
						<div class="commentbox">
						
						<%
							if(listMessages != null)
							{		
								for(MBMessage message : listMessages)
								{
									if(!message.isRoot())
									{
										poster = WallPortletUtil.getUser(message.getUserId());
						%>
		                
							<div class="comment_left_col">
								<a href="javascript:showUserProfile('<%=showUserProfileURL%>', <%=poster.getUserId()%>)" >
	                          		<img height="42" width="41" alt="<%= HtmlUtil.escape(poster.getFullName()) %>" class="profile_pic"  src="<%= poster.getPortraitURL(themeDisplay) %>" />
	                          	</a>
	                      	</div>
	                      	<div class="comment_right_col">
	                          	<p>
	                          		<strong class="notranslate">
	                          			<a href="javascript:showUserProfile('<%=showUserProfileURL%>', <%=poster.getUserId()%>)" ><%= HtmlUtil.escape(poster.getFullName()) %></a>
	                          			<%
		                          			boolean hasMessageDeletePermission = Boolean.FALSE;
		          		                  
	                          				hasMessageDeletePermission = permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), MBMessage.class.getName(), 
	                          						message.getMessageId(), ActionKeys.DELETE);
		    		                  		
		    		                  		if(hasMessageDeletePermission){
	                          			%>
										<a id='<%=String.valueOf(message.getMessageId())%>M' style='float:right;display:none' href='javascript:saveMessage("<%=String.valueOf(message.getMessageId())%>")'>
										Save
										</a>
										<a style='float:right;padding-right:10px' href='javascript:editMessage("<%=String.valueOf(message.getMessageId())%>")'>
											Edit
										</a>
										<a style='float:right;padding-right:10px' href='javascript:confirmDelete("<%=String.valueOf(message.getMessageId())%>")'>
											 Delete
										</a>
										<%
		    		                  		}
										%>
	                          		</strong>
	                          		<span class="span_mini_space">&nbsp;</span>
	                          		<br/>
	                          		<em>Posted
	                          			<% 		                    		
		                    				if(timeZoneId.equalsIgnoreCase(PropsUtil.get("ihg.timezone.utc"))){		                    			
		                    			%>
		                    			<%= WallPortletUtil.getFormattedDate(message.getCreateDate(), locale, timeZone) %>&nbsp;<%=PropsUtil.get("ihg.timezone.gmt")%>
		                    			<%
		                    				} else { %>
		                    			<%= WallPortletUtil.getFormattedDateWithTimeZone(message.getCreateDate(), locale, timeZone) %>
		                    			<% 
		                    				}
										%>
	                          		</em>
									<br/>
									<span class="user_details_brand"><%= CommonUtil.getPeopleDBAttributeValue(companyId, poster.getScreenName(), CommonUtil.PEOPLE_DB_ATTRIBUTE_NAME_BRAND)%></span>
									<span class="user_details_city"><%= CommonUtil.getPeopleDBAttributeValue(companyId, poster.getScreenName(), CommonUtil.PEOPLE_DB_ATTRIBUTE_NAME_CITY)%></span>  
	                          	</p>
	                          	
	                          	<p id="<%=String.valueOf(message.getMessageId())%>">
		                          	<%= StringUtil.replace(message.getBody(true), "@theme_images_path@/emoticons", themeDisplay.getPathThemeImages() + "/emoticons") %>
		                        </p>
	                          	
	                      	</div>
	                      	<div class="clear"></div>
	                      	<div class="divider">&nbsp;</div>
	                      	<div class="clear"></div>
						<%
									}
								}
							}
						%>
							<div class="comment_left_col">
	                      		<img height="42" width="41" alt="<%= HtmlUtil.escape(loggedInUser.getFullName()) %>" class="profile_pic"  src="<%= loggedInUser.getPortraitURL(themeDisplay) %>" />
	                  		</div>
	                  		<div class="comment_right_col">
	                      		<p><strong class="notranslate"><%= loggedInUser.getFullName() %></strong></p>
	                          	<input type="text" name="myComments" class="comment form_item" placeholder="(Type Your Message Here)" />
	                      		<input type="button" value="Submit" 
										onclick="return postReply(this, '<portlet:namespace />', '<%= postReplyURL %>', '<%=msgDisplay.getThread().getCategoryId()%>', '<%=msgDisplay.getThread().getThreadId()%>', '<%=msgDisplay.getThread().getRootMessageId()%>');"  />
								<div style="margin-bottom:4px;"></div>		
	                  		</div>
							<div class="clear"></div>						
						</div>						
		          </div>
		          <div class="clear"></div>
	      		</div><!-- End of "item_inner_container" -->
			</div><!-- End of "item_container" -->
	      	<div class="clear"></div>
	      	
		<%	
				ctr++;
			}
		%>
		
			<div class="item_container">
				<img src="<%=themeDisplay.getPathThemeImages()%>/item_shadow.png" class="item_shadow" alt="item shadow" />
                <!-- <div class="pink_button more_items"><a href="#" class="">View More</a><span></span></div> -->
                <div class="clear"></div>
            </div>
			<div class="clear"></div>
            <img class="wall_bottom_shadow" src="<%=themeDisplay.getPathThemeImages()%>/wall_form_whitebtm.png" alt="wall bottom shadow" />
            
		<%	
		} else {
		%>
			<b><liferay-ui:message key="msg.no.posts" /></b>
		<%	
			}
		%>
      
      	<a href="#" id="dummyNyroAnchor" class="nyroModal"></a>
      
      </div> <!-- end tab 1 -->
</div><!-- End of Div that holds all the Div -->

<script type="text/javascript">

	hideRatingsDislikes();
	
	function showLikers(showLikersURL, messageId)
	{
		showLikersURL += "&myAction=showAllLikers&messageId=" + messageId;
		invokePopUp(showLikersURL);
	}
	
	function showUserProfile(showUserProfileURL, userId)
	{
		showUserProfileURL += "&myAction=showUserProfile&userId=" + userId;
		invokePopUp(showUserProfileURL);
	}
	
	function invokePopUp(resourceURL)
	{
		jQuery('#dummyNyroAnchor').attr('href', resourceURL);
		
		jQuery('#dummyNyroAnchor').nyroModal({
		    autoSizable: true,
		    resizable: false,
		    windowResize: false,
		    width: 640,
		    height: 480
		}).nmCall();
	}
	
	function confirmDelete(id){
		var confirmStatus = confirm("Are you sure to delete this message!");
		var deleteMessageURL = "<%=deleteMessageURL%>&messageId="+id;
		if(confirmStatus == true){
			window.location.href = deleteMessageURL;
		}
	}
	
	function editMessage(id){
		var msgBody = jQuery("p#"+id).text();
		jQuery("p#"+id).html("<input type='text' class='comment form_item'>");
		jQuery("p#"+id).find('input').val(msgBody);
		jQuery("a#"+id+"M").show();
	}
	
	function saveMessage(id){
		var saveMessageURL = "<%=saveMessageURL%>&messageId="+id+"&messageBody="+jQuery("p#"+id).find('input').val();;
		window.location.href = saveMessageURL;
	}
	
	function editThread(id){
		var editThreadURL = "<%=editThreadURL.toString()%>&editThreadId="+id;
		window.location.href = editThreadURL;
	}
		
	$(function(){
		  $(".subs").live('mouseover',function() {
		   if($(this).text() == "Subscribe"){
		    $(this).next('span.subs-tooltip').show();
		   }
		   if($(this).text() == "Unsubscribe"){
		    $(this).next('span.subs-tooltip').hide();
		    $(this).next('span.subs-tooltip-unsubscribe').show();
		   }
		 }).mouseout(function(){
		  $(this).next('span.subs-tooltip').hide();
		  $(this).next('span.subs-tooltip-unsubscribe').hide();
		 });
	});
	
</script>

</form>
