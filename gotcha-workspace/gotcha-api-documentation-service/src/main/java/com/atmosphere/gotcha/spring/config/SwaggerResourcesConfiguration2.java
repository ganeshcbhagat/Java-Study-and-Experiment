package com.atmosphere.gotcha.spring.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class SwaggerResourcesConfiguration2 implements SwaggerResourcesProvider {
	
	@Override
	public List<SwaggerResource> get() {
		System.out.println("----------Here 1 ----------");
		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("FOREX-SERVICE", "http://localhost:8001/v2/api-docs?group=Forex_Micro_Service_Group", "2.0"));
		resources.add(swaggerResource("CURRENCY-CONVERSION-SERVICE", "http://localhost:8100/v2/api-docs?group=Currency_Exchange_Micro_Service_Group", "2.0"));
		return resources;
	}
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
