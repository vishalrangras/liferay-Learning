public PRProduct addProduct(PRProduct newProduct, long userId)
throws SystemException, PortalException {
PRProduct product = prProductPersistence.create(
counterLocalService.increment(
PRProduct.class.getName()));
resourceLocalService.addResources(
newProduct.getCompanyId(),
newProduct.getGroupId(), userId,
PRProduct.class.getName(),
product.getPrimaryKey(), false,
true, true);
product.setProductName(newProduct.getProductName());
product.setSerialNumber(newProduct.getSerialNumber());
product.setCompanyId(newProduct.getCompanyId());
product.setGroupId(newProduct.getGroupId());
return prProductPersistence.update(product, false);
}

public void deleteProduct(long productId)
throws NoSuchProductException, SystemException, PortalException {
PRProduct product =
prProductPersistence.findByPrimaryKey(productId);
deleteProduct(product);
}

public void deleteProduct(PRProduct product)
throws PortalException, SystemException {
resourceLocalService.deleteResource(
product.getCompanyId(), PRProduct.class.getName(),
ResourceConstants.SCOPE_INDIVIDUAL, product.getPrimaryKey());
prProductPersistence.remove(product);
}

public List<PRProduct> getAllProducts(long groupId)
throws SystemException {
List<PRProduct> products =
prProductPersistence.findByGroupId(groupId);
return products;
}

docroot/WEB-INF/src/com/inkwell/internet/productregistration/service/impl/PRProductLocalServiceImpl.java
