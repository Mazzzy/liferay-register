package com.liferay.register.portlet;

import com.liferay.register.constants.RegisterPortletKeys;
import com.liferay.register.services.model.Register;
import com.liferay.register.services.service.RegisterLocalService;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.StringWriter;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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
	
	private void sendMail(String registerName, String registerSurname, String registerEmail) throws AddressException {
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		String combinedName = registerName + " " + registerSurname;
		String greetMsg = "Welcome Onboard!";
		String infoText = "You have successfully registered in our system.<br/>" + 
				"Thanks for choosing liferay as your platform!";
		String footerText = "Best Regards,<br/>" + 
				"Mazzzy,<br/>" + 
				"Liferay support team";
		
		String body = "";		

		try {
			TemplateResource templateResource = 
				new URLTemplateResource("0",this.getClass().getClassLoader().getResource("/content/registermsg.ftl"));
			Template template = TemplateManagerUtil.getTemplate(
			TemplateConstants.LANG_TYPE_FTL, templateResource, false);
			
			// dynamic text in template
			template.put("NAME", combinedName);
			template.put("GREET", greetMsg);
			template.put("INFO", infoText);
			template.put("FOOTER", footerText);	
			
	        
			StringWriter out = new StringWriter();
        
        	template.processTemplate(out);
        	body = out.toString();		        
		} catch (TemplateException e1) {
			e1.printStackTrace();
		}
		
		// send email
		try {
			// from address Gmail is added in configuration of Liferay, under control panel -> Server Adminstartion -> Mail.
    		// replace xxxxxxx with your configured gmail
			fromAddress = new InternetAddress("xxxxxxx@gmail.com");
    		toAddress = new InternetAddress(registerEmail);
    		
    		MailMessage mailMessage = new MailMessage();
    		mailMessage.setTo(toAddress);
    		mailMessage.setFrom(fromAddress);
    		
    		mailMessage.setSubject("Registration confirmation in Liferay App");
    		
    		mailMessage.setBody(body);
    		mailMessage.setHTMLFormat(true);
    		MailServiceUtil.sendEmail(mailMessage);
			
    		System.out.println("Registration email sent...");
		} catch (AddressException e) {
	    	e.printStackTrace();
		}
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
		
		// after save in DB send email
		try {
			sendMail(name, surname, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}