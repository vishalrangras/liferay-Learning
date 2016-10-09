<liferay-ui:error key="birthdate-required" message="date-of-birth-required" />

  <% 
     Calendar dob = CalendarFactoryUtil.getCalendar(); 
     dob.setTime(regUser.getBirthDate());
  %>
  
<aui:input name="birthDate" model="<%= PRUser.class %>" bean="<%= regUser %>" value="<%= dob %>" />

<%
  List<PRProduct> products = PRProductLocalServiceUtil.getAllProducts(themeDisplay.getScopeGroupId());
%>

<aui:select name="productType">

  <aui:option value="-1">
    <liferay-ui:message key="please-choose" />
  </aui:option>

  <%
    for (PRProduct product : products) {
  %>

   <aui:option value="<%= product.getProductId() %>">
      <%= product.getProductName() %>
   </aui:option>
  
  <%
    }
  %>

</aui:select>
