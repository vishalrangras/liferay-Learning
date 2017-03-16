<%@ include file="init.jsp" %>
<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		
		<span class="user-avatar-link">
			<a class="text-default" data-qa-id="openUserMenu" href="javascript:;" id="<portlet:namespace />sidenavUserToggle">
				<c:if test="<%= themeDisplay.isImpersonated() %>">
					<aui:icon image="asterisk" markupView="lexicon" />
				</c:if>

				<span class="user-avatar-image">
					<liferay-ui:user-portrait
					imageCssClass="user-icon-lg"
					userId="<%= user.getUserId() %>"
					/>
				</span>				
			</a>
			
			<%
			int notificationsCount = GetterUtil.getInteger(request.getAttribute(CustomUserBarKeys.NOTIFICATIONS_COUNT));
			%>

			<c:if test="<%= notificationsCount > 0 %>">

				<%
				PortletURL notificationsURL = PortletProviderUtil.getPortletURL(request, UserNotificationEvent.class.getName(), PortletProvider.Action.VIEW);
				%>
				
				<aui:a class="bell-notification" href="<%= notificationsURL != null ? notificationsURL.toString() : null %>">
					<i class="fa fa-bell-o"></i>
					<span class="panel-notifications-count sticker sticker-right sticker-rounded sticker-sm sticker-warning"><%= notificationsCount %></span>
				</aui:a>		
			</c:if>		
		
		
			<a target="_blank" href="#" class="sIcons icon-mail"><i class="fa fa-envelope-o"></i></a>

			
		</span>

		<aui:script sandbox="<%= true %>">
			var sidenavUserToggle = $('#<portlet:namespace />sidenavUserToggle');

			sidenavUserToggle.on(
				'click',
				function(event) {
					Liferay.fire('ProductMenu:openUserMenu');
				}
			);
		</aui:script>
	</c:when>
	<c:otherwise>

		<%
		Map<String, Object> anchorData = new HashMap<String, Object>();

		anchorData.put("redirect", String.valueOf(PortalUtil.isLoginRedirectRequired(request)));
		%>

		<span class="sign-in text-default" role="presentation">
			<aui:a cssClass="sign-in text-default" data="<%= anchorData %>" href="http://lrdxpdemo.cignex.com/web/clsa/login" iconCssClass="icon-user" label="sign-in" />
		</span>
	</c:otherwise>
</c:choose>