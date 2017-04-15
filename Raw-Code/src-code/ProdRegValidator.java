public static boolean validateProduct(PRProduct product, List errors) {
boolean valid = true;
if (Validator.isNull(product.getProductName())) {
errors.add("product-name-required");
valid = false;
}
if (Validator.isNull(product.getSerialNumber())) {
errors.add("serial-number-prefix-required");
valid = false;
}
if (Validator.isNull(product.getCompanyId())) {
errors.add("missing-company-id");
valid = false;
}
if (Validator.isNull(product.getGroupId())) {
errors.add("missing-group-id");
valid = false;
}
return valid;
}

//docroot/WEB-INF/src/com/inkwell/internet/productregistration/portlet/ProdRegValidator.java
