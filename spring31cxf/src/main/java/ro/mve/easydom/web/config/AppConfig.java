package ro.mve.easydom.web.config;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import ro.mve.easydom.web.ShopOrderService;

@Configuration
@ImportResource("classpath:cxf-config.xml")
// @ImportResource("classpath:META-INF/cxf/cxf-all.xml")
public class AppConfig {

	// @Bean
	ShopOrderService shopOrderService() {
		return new ShopOrderService();
	}

	// @Bean
	JAXRSServerFactoryBean JAXRSServer() {
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setServiceBean(this.shopOrderService());
		sf.setAddress("/");
		sf.setProvider(new org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider());
		sf.create();
		return sf;
	}

}
