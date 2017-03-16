package com.cd.coe.custom.bar;

import com.cd.coe.custom.userbar.constants.CustomUserBarKeys;
import com.liferay.admin.kernel.util.PortalUserPersonalBarApplicationType;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"model.class.name=" + PortalUserPersonalBarApplicationType.UserPersonalBar.CLASS_NAME,
			"service.ranking:Integer=20"
		},
		service = ViewPortletProvider.class
	)
public class CustomUserBarViewPortletProvider extends BasePortletProvider implements ViewPortletProvider{

	@Override
	public String getPortletName() {
		// TODO Auto-generated method stub
		return CustomUserBarKeys.CUSTOM_PRODUCT_NAVIGATION_USER_PERSONAL_BAR;
	}

}
