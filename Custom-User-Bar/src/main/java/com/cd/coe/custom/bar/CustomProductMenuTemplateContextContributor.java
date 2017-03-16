package com.cd.coe.custom.bar;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.template.TemplateContextContributor;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.SessionClicks;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
				"type=" + TemplateContextContributor.TYPE_THEME,
				"service.ranking:Integer=20"
				},
		service = TemplateContextContributor.class
	)
	public class CustomProductMenuTemplateContextContributor
		implements TemplateContextContributor {
	
	public static final String PRODUCT_NAVIGATION_PRODUCT_MENU_STATE =
			"com.liferay.product.navigation.product.menu.web_productMenuState";

		@Override
		public void prepare(
			Map<String, Object> contextObjects, HttpServletRequest request) {
			if (!isShowProductMenu(request)) {
				_log.info("Returning from if block...");
				return;
			}
			_log.info("Did not returned...");
			String cssClass = GetterUtil.getString(
				contextObjects.get("bodyCssClass"));
			String productMenuState = SessionClicks.get(
				request,PRODUCT_NAVIGATION_PRODUCT_MENU_STATE,
				"closed");

			contextObjects.put(
				"bodyCssClass", cssClass + StringPool.SPACE + productMenuState);

			contextObjects.put("liferay_product_menu_state", productMenuState);
		}

		protected boolean isShowProductMenu(HttpServletRequest request) {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			if (themeDisplay.isImpersonated()) {
				return true;
			}

			if (!themeDisplay.isSignedIn()) {
				return false;
			}

			User user = themeDisplay.getUser();

			if (!user.isSetupComplete()) {
				return false;
			}
			
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			boolean isAdmin = permissionChecker.isOmniadmin();
			_log.info("Value of isAdmin is: "+isAdmin);
			if(!isAdmin){
				_log.info("Inside ifAdmin test...");
				return false;
			}
			_log.info("Returning true from isShowProductMenu...");
			return true;
		}
		
		private static final Log _log = LogFactoryUtil.getLog(
				CustomProductMenuTemplateContextContributor.class);

}
