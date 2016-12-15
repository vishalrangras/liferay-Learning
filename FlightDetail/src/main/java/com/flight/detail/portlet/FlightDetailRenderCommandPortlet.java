package com.flight.detail.portlet;

import com.flight.detail.ws.executor.util.FlightDetail;
import com.flight.detail.ws.executor.util.FlightDetailConstants;
import com.flight.detail.ws.executor.util.FlightUtil;
import com.flight.detail.ws.executor.util.RestExecutor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FlightDetail Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FlightDetailRenderCommandPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String response = RestExecutor.getResponse();
		System.out.println("response --->"+response);
		List<FlightDetail> flightDetailList = FlightUtil.getFlightDetail(response);
		System.out.println("size--->"+flightDetailList.size());
		renderRequest.setAttribute(FlightDetailConstants.FLIGHTDETAIL_LIST,flightDetailList);
		super.doView(renderRequest, renderResponse);
		
	}
}