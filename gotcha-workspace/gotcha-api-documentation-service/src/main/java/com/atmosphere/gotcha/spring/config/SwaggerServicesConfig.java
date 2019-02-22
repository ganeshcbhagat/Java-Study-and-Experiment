package com.atmosphere.gotcha.spring.config;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/*@Component
@EnableAutoConfiguration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "documentation.swagger")*/
public class SwaggerServicesConfig {

	private List<SwaggerServices> swagger;

	public List<SwaggerServices> getServices() {
		return swagger;
	}

	public void setServices(List<SwaggerServices> swaggerResources) {
		this.swagger = swaggerResources;
	}

}