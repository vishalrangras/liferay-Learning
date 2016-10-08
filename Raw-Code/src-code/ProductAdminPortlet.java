public void addProduct(ActionRequest request, ActionResponse response)
throws Exception {
ThemeDisplay themeDisplay =
(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
PRProduct product = ActionUtil.productFromRequest(request);
ArrayList<String> errors = new ArrayList<String>();
if (ProdRegValidator.validateProduct(product, errors)) {
PRProductLocalServiceUtil.addProduct(
product,themeDisplay.getUserId());
SessionMessages.add(request, "product-saved-successfully");
}
else {
SessionErrors.add(request, "fields-required");
}
}

//docroot/WEB-INF/src/com/inkwell/internet/productregistration/portlet/ProductAdminPortlet.java
