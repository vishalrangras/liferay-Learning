<%@include file="../init.jsp" %>

<div style="width:350px;padding-left:15px;">
	<br/>
	<p><b>Here are all the Likers!</b></p>
	<br/>
	<br/>
	<%
		List<User> likersList = (List<User>) request.getAttribute("likersList");
		if(!likersList.isEmpty())
		{
			for(User liker : likersList)
			{
	%>
			<div class="user-info">
				<p class="float-container">
					<img alt="<%= HtmlUtil.escape(liker.getFullName()) %>" class="avatar" src="<%= liker.getPortraitURL(themeDisplay) %>" />
	
					<span><b><%= HtmlUtil.escape(liker.getFullName()) %></b></span> 
				</p>
			</div>
			<br/>
			<br/>	
	<%
			}
		}else{
	%>
		<b><liferay-ui:message key="msg.first.one" /></b> &nbsp; <img src="<%=themeDisplay.getPathThemeImages()%>/emoticons/smile.gif" alt="Smile" />
	<%
		}
	%>
	
	<br/>
	<br/>
</div>	

