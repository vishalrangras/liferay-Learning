public void addRegistration(ActionRequest request, ActionResponse response) {
  
  ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
  PRRegistration registration = new PRRegistrationImpl();
  PRUser prUser = new PRUserImpl();
  
  if (themeDisplay.isSignedIn()) {
    
    User user = themeDisplay.getUser();
    
    List<Address> addresses = Collections.EMPTY_LIST;
    
    Address homeAddr = null;
      
      try {
        
        addresses = AddressLocalServiceUtil.getAddresses(user.getCompanyId(), User.class.getName(), user.getUserId());
      
      } catch (SystemException ex) {
        
      }

      if (addresses.size() > 0) {
        homeAddr = addresses.get(0);
      }
      
      prUser.setFirstName(user.getFirstName());
      prUser.setLastName(user.getLastName());
      prUser.setEmail(user.getEmailAddress());

      try {

        prUser.setBirthDate(user.getBirthday());
        boolean male = user.getMale();

        if (male) {
          prUser.setGender("male");
        } 
        else {
          prUser.setGender("female");
        }
        
        prUser.setMale(male);
        
      }
      catch (PortalException e) {
        prUser.setBirthDate(new Date());
      }
      catch (SystemException e) {
        prUser.setMale(true);
      }
      
      if (homeAddr != null) {
        prUser.setAddress1(homeAddr.getStreet1());
        prUser.setAddress2(homeAddr.getStreet2());
        prUser.setCity(homeAddr.getCity());
        prUser.setPostalCode(homeAddr.getZip());
        prUser.setCountry(homeAddr.getCountry().toString());
      }
      
      registration.setDatePurchased(new Date());
      }
      
      else {
        registration.setDatePurchased(new Date());
        Calendar dob = CalendarFactoryUtil.getCalendar();
        dob.set(Calendar.YEAR, 1970);
        prUser.setBirthDate(dob.getTime());
        prUser.setGender("");
      }

      request.setAttribute("regUser", prUser);
      request.setAttribute("registration", registration);
      response.setRenderParameter("jspPage", viewAddRegistrationJSP);
}

public void registerProduct(ActionRequest request, ActionResponse response) throws Exception {
    PRUser regUser = ActionUtil.prUserFromRequest(request);
    PRRegistration registration = ActionUtil.prRegistrationFromRequest(request);
    ArrayList<String> errors = new ArrayList<String>();
    
    ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
    long userId = themeDisplay.getUserId();

    User liferayUser = UserLocalServiceUtil.getUser(userId);
    boolean userValid = ProdRegValidator.validateUser(regUser, errors);
    boolean regValid = ProdRegValidator.validateRegistration(registration, errors);

    if (userValid && regValid) {
        PRUser user = null;
      if (liferayUser.isDefaultUser()) {
          userId = 0;
          user = PRUserLocalServiceUtil.addPRUser(regUser, userId);

      }
      else {
          user = PRUserLocalServiceUtil.getPRUser(
          themeDisplay.getScopeGroupId(), userId);
          if (user == null) {
            regUser.setUserId(userId);
            user = PRUserLocalServiceUtil.addPRUser(regUser, userId);
          }
      }
      
      registration.setPrUserId(user.getPrUserId());
      PRRegistrationLocalServiceUtil.addRegistration(registration);
      SessionMessages.add(request,"registration-saved-successfully");
      response.setRenderParameter("jspPage", viewThankYouJSP);
  }
  else {
    for (String error : errors) {
      SessionErrors.add(request, error);
    }
    SessionErrors.add(request, "error-saving-registration");
    response.setRenderParameter("jspPage", viewAddRegistrationJSP);
    request.setAttribute("regUser", regUser);
    request.setAttribute("registration", registration);
  }
}
