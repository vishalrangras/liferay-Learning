public void addProduct(ActionRequest request, ActionResponse response) throws Exception {
  
  ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
  PRProduct product = ActionUtil.productFromRequest(request);
  ArrayList<String> errors = new ArrayList<String>();
  
  if (ProdRegValidator.validateProduct(product, errors)) {
      PRProductLocalServiceUtil.addProduct(product,themeDisplay.getUserId());
      SessionMessages.add(request, "product-saved-successfully");
  }
  else {
      SessionErrors.add(request, "fields-required");
  }
}

public void editProduct(ActionRequest request, ActionResponse response) throws Exception {

  long productKey = ParamUtil.getLong(request, "resourcePrimKey");

  if (Validator.isNotNull productKey)) {

    PRProduct product = PRProductLocalServiceUtil.getPRProduct(productKey);
    
    request.setAttribute("product", product);
    response.setRenderParameter("jspPage", editProductJSP);
  }
}

//docroot/WEB-INF/src/com/inkwell/internet/productregistration/portlet/ProductAdminPortlet.java
