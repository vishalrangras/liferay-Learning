<liferay-ui:error key="birthdate-required" message="date-of-birth-required" />

  <% 
     Calendar dob = CalendarFactoryUtil.getCalendar(); 
     dob.setTime(regUser.getBirthDate());
  %>
  
<aui:input name="birthDate" model="<%= PRUser.class %>" bean="<%= regUser %>" value="<%= dob %>" />
