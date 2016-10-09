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

   /**
     * This Action updates an existing product with values that were entered
     * into the edit_product.jsp.
     *
     * @param request
     * @param response
     * @throws java.lang.Exception
     */

    public void updateProduct(ActionRequest request, ActionResponse response)
        throws Exception {

        long productKey = ParamUtil.getLong(request, "resourcePrimKey");
        ArrayList<String> errors = new ArrayList();
        if (Validator.isNotNull(productKey)) {
            PRProduct product =
                PRProductLocalServiceUtil.getPRProduct(productKey);
            PRProduct requestProduct = ActionUtil.productFromRequest(request);

            if (ProdRegValidator.validateProduct(requestProduct, errors)) {
                product.setProductName(requestProduct.getProductName());
                product.setSerialNumber(requestProduct.getSerialNumber());
                PRProductLocalServiceUtil.updatePRProduct(product);
                SessionMessages.add(request, "productUpdated");

            }
            else {
                for (String error : errors) {
                    SessionErrors.add(request, error);

                }

            }

        }
        else {
            SessionErrors.add(request, "error-updating");
        }

    }

    /**
     * This Action deletes a product from the database.
     *
     * @param request
     * @param response
     * @throws java.lang.Exception
     */
    public void deleteProduct(ActionRequest request, ActionResponse response)
        throws Exception {

        long productKey = ParamUtil.getLong(request, "resourcePrimKey");

        if (Validator.isNotNull(productKey)) {
            PRProductLocalServiceUtil.deleteProduct(productKey);
            SessionMessages.add(request, "productDeleted");
        }
        else {
            SessionErrors.add(request, "error-deleting");
        }
    }

//docroot/WEB-INF/src/com/inkwell/internet/productregistration/portlet/ProductAdminPortlet.java
