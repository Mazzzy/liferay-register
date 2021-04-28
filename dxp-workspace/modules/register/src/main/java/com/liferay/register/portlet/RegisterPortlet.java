package com.liferay.register.portlet;

import com.liferay.register.constants.RegisterPortletKeys;
import com.liferay.register.services.model.Register;
import com.liferay.register.services.service.RegisterLocalService;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
	@Reference
	private RegisterLocalService _registerLocalService;
	
	private Date StringtoDate(String date) throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        if( !date.isEmpty()) {

            java.util.Date normalDate = sdf1.parse(date);
			sqlDate = new java.sql.Date(normalDate.getTime());
        }
        return sqlDate;
    }
	
	public void registerSubmit(ActionRequest request, ActionResponse response) 
	 throws IOException, PortletException {
		String name = ParamUtil.getString(request, "name");
		String surname = ParamUtil.getString(request, "surname");
		String bdate = ParamUtil.getString(request, "bdate");
		String email = ParamUtil.getString(request, "email");
		
		// db call
		Register register = _registerLocalService.createRegister(CounterLocalServiceUtil.increment());
		register.setName(name);
		register.setSurname(surname);
		try {
			register.setBdate(StringtoDate(bdate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		register.setEmail(email);
		_registerLocalService.addRegister(register);
		
		System.out.println("=== Succesfully Added to DB "+name+" : "+surname+" : "+bdate+" : "+email);
	}
}