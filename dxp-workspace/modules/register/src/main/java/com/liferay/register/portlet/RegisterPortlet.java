package com.liferay.register.portlet;

import com.liferay.register.constants.RegisterPortletKeys;

import java.io.IOException;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author mazaharshaikh
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Register",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RegisterPortletKeys.REGISTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RegisterPortlet extends MVCPortlet {
	
	public void registerSubmit(ActionRequest request, ActionResponse response) 
	 throws IOException, PortletException {
		String name = ParamUtil.getString(request, "name");
		String surname = ParamUtil.getString(request, "surname");
		String bdate = ParamUtil.getString(request, "bdate");
		String email = ParamUtil.getString(request, "email");
		
		System.out.println("=== Passed "+name+" : "+surname+" : "+bdate+" : "+email);
	}
}