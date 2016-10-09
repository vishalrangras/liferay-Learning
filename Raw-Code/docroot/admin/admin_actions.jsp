<%@include file="/init.jsp" %>

  <% 
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    PRProduct myProduct = (PRProduct) row.getObject();
    long groupId = themeDisplay.getLayout().getGroupId();
    String name = PRProduct.class.getName();
    String primKey = String.valueOf(myProduct.getPrimaryKey());
  %>

<liferay-ui:icon-menu>

    <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
      <portlet:actionURL name="editProduct" var="editURL">
          <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
      </portlet:actionURL>
      <liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />
    </c:if>
    
    <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey,ActionKeys.DELETE) %>">
      <portlet:actionURL name="deleteProduct" var="deleteURL">
        <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
      </portlet:actionURL>
      <liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
    </c:if>

    <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>">
      <liferay-security:permissionsURL modelResource="<%= PRProduct.class.getName() %>"
          modelResourceDescription="<%= myProduct.getProductName() %>"
          resourcePrimKey="<%= primKey %>"
          var="permissionsURL"
      />
      <liferay-ui:icon image="permissions" url="<%= permissionsURL.toString() %>" />
    </c:if>

</liferay-ui:icon-menu>
