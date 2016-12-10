<%@include file="init-wall.jsp" %>

	<portlet:actionURL var="wallPrefURL">
		<portlet:param name="myAction" value="saveWallPref" />
	</portlet:actionURL>
	
	<portlet:renderURL var="defaultURL" portletMode="view">
	</portlet:renderURL>
	
<form name="wallPrefForm" id="wallPrefForm" method="post" action="<%=wallPrefURL.toString()%>">
	
	<input type="hidden" name="mainRedirect" id="mainRedirect" value="<%=defaultURL.toString()%>" />
	
			<%
				String prefDelta = "";
				if(request.getAttribute("threadsDelta") != null)
				{
					prefDelta = request.getAttribute("threadsDelta").toString();	
				}
				
				String sendEmailNotifications = "yes";
				if(request.getAttribute("sendEmailNotifications") != null)
				{
					sendEmailNotifications = request.getAttribute("sendEmailNotifications").toString();	
				}
			%>
				
	<table width="500px;" style="margin-left:50px;">
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<a style="margin-left:420px;" href="<%=defaultURL.toString()%>">
					<img src="<%=themeDisplay.getPathThemeImages()%>/arrows/01_left.png" />
					&nbsp;<strong><liferay-ui:message key="back" /></strong>
				</a>
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>		
			<td width="70%"><strong><liferay-ui:message key="label.no.threads" />:</strong></td>
			<td>
				<select id="threadsDelta" name="threadsDelta">
					<% if(prefDelta.equalsIgnoreCase("10")) { %> <option value="10" selected="true">10</option> <% } else { %> <option value="10">10</option> <% } %> 
					<% if(prefDelta.equalsIgnoreCase("20")) { %> <option value="20" selected="true">20</option> <% } else { %> <option value="20">20</option> <% } %>
					<% if(prefDelta.equalsIgnoreCase("30")) { %> <option value="30" selected="true">30</option> <% } else { %> <option value="30">30</option> <% } %>
					<% if(prefDelta.equalsIgnoreCase("50")) { %> <option value="50" selected="true">50</option> <% } else { %> <option value="50">50</option> <% } %>
					<% if(prefDelta.equalsIgnoreCase("75")) { %> <option value="75" selected="true">75</option> <% } else { %> <option value="75">75</option> <% } %>
					<% if(prefDelta.equalsIgnoreCase("100")) { %> <option value="100" selected="true">100</option> <% } else { %> <option value="100">100</option> <% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>		
			<% 
				String yes = SocialPortletCommonsConstants.SEND_EMAIL_YES;
				String no = SocialPortletCommonsConstants.SEND_EMAIL_NO;
			%>
			<td width="70%"><strong><liferay-ui:message key="label.send.email" />:</strong></td>
			<td>
				<select id="sendEmail" name="sendEmail">
					<% if(sendEmailNotifications.equalsIgnoreCase(yes)) { %> <option value="<%=yes%>" selected="true"><%=yes%></option> <% } else { %> <option value="<%=yes%>"><%=yes%></option> <% } %> 
					<% if(sendEmailNotifications.equalsIgnoreCase(no)) { %> <option value="<%=no%>" selected="true"><%=no%></option> <% } else { %> <option value="<%=no%>"><%=no%></option> <% } %>					
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input style="margin-left:200px;" type="submit" value='<liferay-ui:message key="label.save.pref" />' name="btnSave" id="btnSave" />
			</td>
		</tr>
	</table>
	
</form>