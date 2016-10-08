<liferay-ui:success key="productSaved" message="product-saved-successfully" />
<liferay-ui:success key="productDeleted" message="productDeleted" />
<liferay-ui:success key="productUpdated" message="productUpdated" />
<liferay-ui:error key="fields-required" message="fields-required" />
<liferay-ui:error key="error-deleting" message="error-deleting" />
<liferay-ui:error key="error-updating" message="error-updating" />

<portlet:actionURL name="addProduct" var="addProductURL"/>
<aui:form action="<%= addProductURL.toString() %>" method="post">
<aui:fieldset>
<aui:input name="productName" size="45" />
<aui:input name="productSerial" size="45" />
<aui:button-row>
<aui:button type="submit" />
</aui:button-row>
</aui:fieldset>
</aui:form>

<!-- Missed the comment about comming in previous comment so adding it in this commit-->
