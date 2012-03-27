package ro.mve.easydom.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer // implements WebApplicationInitializer
{
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(AppConfig.class, WebConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(
				mvcContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/mvc/*");

		ServletRegistration.Dynamic cxf = servletContext.addServlet("cxf",
				new org.apache.cxf.transport.servlet.CXFServlet());

		cxf.setLoadOnStartup(1);
		cxf.addMapping("/api/*");
	}
}