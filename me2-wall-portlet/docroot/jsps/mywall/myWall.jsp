<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="init-wall.jsp" %>

<%
long threadId = 0l;
if(Validator.isNotNull(request.getAttribute("editThreadId"))){
	threadId = Long.parseLong(request.getAttribute("editThreadId").toString());
}

MBCategory category = (MBCategory)request.getAttribute("MESSAGE_BOARDS_CATEGORY");

Set<Long> categorySubscriptionClassPKs = null;
Set<Long> threadSubscriptionClassPKs = null;

if (themeDisplay.isSignedIn()) {
	categorySubscriptionClassPKs = WallPortletUtil.getCategorySubscriptionClassPKs(user.getUserId());
	threadSubscriptionClassPKs = WallPortletUtil.getThreadSubscriptionClassPKs(user.getUserId());
}
String sector="";

if(PropsUtil.get(""+themeDisplay.getScopeGroupId())!=null){
	sector = PropsUtil.get(""+themeDisplay.getScopeGroupId());
}

%>

	<portlet:renderURL var="defaultRenderURL"></portlet:renderURL>

		<div class="grid_8">
        	<div class="wall_left_col">
        	
        		
                
                	<c:choose>
						<c:when test="<%= (categorySubscriptionClassPKs != null) && categorySubscriptionClassPKs.contains(category.getCategoryId()) %>">
													
							<portlet:actionURL var="unsubscribeCategoryURL">
								<portlet:param name="myAction" value="unsubscribeCategory" />
								<portlet:param name="mbCategoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
							</portlet:actionURL>

							<div class="subs-tooltip-container"><a href="<%=unsubscribeCategoryURL.toString()%>" class="subs-all gray">Unsubscribe to all</a>
								<span class="subs-tooltip-unsubscribe-all">Click unsubscribe to stop receiving updates when another user posts in the <span><%=sector%></span> sector
									<span class="arr-tooltip"></span>
								</span>
							</div>
						</c:when>
						<c:otherwise>
							<portlet:actionURL var="subscribeCategoryURL">
								<portlet:param name="myAction" value="subscribeCategory" />
								<portlet:param name="mbCategoryId" value="<%= String.valueOf(category.getCategoryId()) %>" />
							</portlet:actionURL>

							<div class="subs-tooltip-container"><a href="<%=subscribeCategoryURL.toString()%>" class="subs-all">Subscribe to all</a>
                				<span class="subs-tooltip-all">Click subscribe to receive updates when another user posts in the <span><%=sector%></span> sector
                        			<span class="arr-tooltip"></span>
                        		</span>
                        	</div>
						</c:otherwise>
					</c:choose>
        	
        		<div class="wall_form_topbar">
                   <h2 class="wall_form_topbar_title">Collaborate and Share</h2>
		        </div>
        		<div class="clear"></div>
        		
        		<%
        			if(threadId > 0l){
        		%>
        				<%@include file="editThread.jsp" %>
        		<%
        			}else{
        		 %>
        		
						<%@include file="startThread.jsp" %>
		
						<div class="clear"></div>
		            	<img src="<%=themeDisplay.getPathThemeImages()%>/wall_form_whitebtm.png" class="wall_form_btm" />
		            	<div class="clear"></div>
		
						<%@include file="wallPosts.jsp" %>
				
				<%
        			}
				%>
	
			</div>
		</div>
			
		<div class="clear"></div>
		
		<script type="text/javascript">
			function googleTranslateElementInit() {
	  			new google.translate.TranslateElement({pageLanguage: 'en', gaTrack: true, gaId: '$analyticsId'}, 'google_translate_element');
			};

		$(function(){
				$(".subs-all").mouseover(function() {
					if($(this).text() == "Subscribe to all"){
						$('.subs-tooltip-all').show();
					}
					if($(this).text() == "Unsubscribe to all"){
						$('.subs-tooltip-all').hide();
						$('.subs-tooltip-unsubscribe-all').show();
					}
			}).mouseout(function(){
				$('.subs-tooltip-all').hide();
				$('.subs-tooltip-unsubscribe-all').hide();
			});
		});
		
		</script>