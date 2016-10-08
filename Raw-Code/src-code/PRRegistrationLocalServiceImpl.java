public PRRegistration addRegistration(PRRegistration reg)
throws SystemException, PortalException {
PRRegistration registration =
prRegistrationPersistence.create(
counterLocalService.increment(
PRRegistration.class.getName()));
resourceLocalService.addResources(
registration.getCompanyId(),
registration.getGroupId(),
PRRegistration.class.getName(),
false);
registration.setCompanyId(reg.getCompanyId());
registration.setDatePurchased(reg.getDatePurchased());
registration.setGroupId(reg.getGroupId());
registration.setHowHear(reg.getHowHear());
registration.setProductId(reg.getProductId());
registration.setPrUserId(reg.getPrUserId());
registration.setSerialNumber(reg.getSerialNumber());
registration.setWherePurchased(reg.getWherePurchased());
return prRegistrationPersistence.update(registration, false);
}

public List<PRRegistration> getAllRegistrations(long groupId)
throws SystemException {
List<PRRegistration>registrations =
prRegistrationPersistence.findByGroupId(groupId);
return registrations;
}

docroot/WEB-INF/src/com/inkwell/internet/productregistration/service/impl/PRRegistrationLocalServiceImpl.java
