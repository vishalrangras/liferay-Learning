<%@include file="/init.jsp" %>

<% PRProduct product = (PRProduct) request.getAttribute("product"); %>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/admin/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="updateProduct" var="updateProductURL" />

<h2>Edit A Product</h2>

<aui:form name="fm" action="<%= updateProductURL.toString() %>" method="post">
  <aui:fieldset>
    
    <aui:input name="resourcePrimKey" value="<%= product.getProductId() %>" type="hidden" />
    <aui:input name="productName" value="<%= product.getProductName() %>" size="45" />
    <aui:input name="productSerial" value="<%= product.getSerialNumber() %>" size="45" />

    <aui:button-row>
      
      <aui:button type="submit"/>
      <aui:button type="cancel" value="Cancel" onClick="<%= cancelURL.toString () %>"/>

    </aui:button-row>
  
  </aui:fieldset>

</aui:form>
