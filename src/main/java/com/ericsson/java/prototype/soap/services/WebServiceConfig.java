package com.ericsson.java.prototype.soap.services;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
	/*WSDL URL:
	 * http://localhost:8080/subscriber-data/subscribers.wsdl*/

	@Bean
	  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
	    MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
	    messageDispatcherServlet.setApplicationContext(context);
	    messageDispatcherServlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean(messageDispatcherServlet, "/subscriber-data/*");
	}
	
	@Bean(name = "subscribers")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema subscribersSchema) {
	  DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
	  definition.setPortTypeName("SubscriberPort");
	  definition.setTargetNamespace("http://www.ericsson.com/java/prototype/soap/services");
	  definition.setLocationUri("/subscriber-data");
	  definition.setSchema(subscribersSchema);
	  return definition;
	}
	
	@Bean
	public XsdSchema subscriberSchema() {
	  return new SimpleXsdSchema(new ClassPathResource("SubscriberSOAPSchema.xsd"));
	}
}
