public PRUser addPRUser(PRUser user, long userId)
throws SystemException, PortalException {
PRUser prUser =
prUserPersistence.create(
counterLocalService.increment(
PRUser.class.getName()));
resourceLocalService.addResources(
prUser.getCompanyId(), prUser.getGroupId(),
PRUser.class.getName(), false);
prUser.setAddress1(user.getAddress1());
prUser.setAddress2(user.getAddress2());
prUser.setBirthDate(user.getBirthDate());
prUser.setCity(user.getCity());
prUser.setCompanyId(user.getCompanyId());
prUser.setCountry(user.getCountry());
prUser.setEmail(user.getEmail());
prUser.setFirstName(user.getFirstName());
prUser.setGroupId(user.getGroupId());
prUser.setLastName(user.getLastName());
prUser.setMale(user.getMale());
prUser.setPhoneNumber(user.getPhoneNumber());
prUser.setPostalCode(user.getPostalCode());
prUser.setState(user.getState());
prUser.setUserId(userId);
return prUserPersistence.update(prUser, false);
}

docroot/WEB-INF/src/com/inkwell/internet/productregistration/service/impl/PRUserLocalServiceImpl.java
