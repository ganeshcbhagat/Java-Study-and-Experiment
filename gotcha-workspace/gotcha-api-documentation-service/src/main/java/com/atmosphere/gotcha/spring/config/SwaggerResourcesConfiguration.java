package com.atmosphere.gotcha.spring.config;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

//@Configuration
public class SwaggerResourcesConfiguration {

	@Autowired
	private ZuulProperties properties;

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider() {
		/*return () -> {
			List<SwaggerResource> resources = new ArrayList<>();
			properties.getRoutes().values().stream().forEach(new Consumer<ZuulRoute>() {
				@Override
				public void accept(ZuulRoute zuulRoute) {
					resources.add(swaggerResource(zuulRoute.getServiceId(), "/"+zuulRoute.getId()+"/v2/api-docs", "2.0"));
				}
			});
			return resources;
		};*/

		List<SwaggerResource> resources = new ArrayList<>();
		resources.add(swaggerResource("FOREX-SERVICE", "/v2/api-docs?group=Forex_Micro_Service_Group", "2.0"));
		resources.add(swaggerResource("CURRENCY-CONVERSION-SERVICE", "/v2/api-docs?group=Currency_Exchange_Micro_Service_Group", "2.0"));
		SwaggerResourcesProvider swaggerResourcesProvider = new SwaggerResourcesProvider() {
			@Override
			public List<SwaggerResource> get() {
				return resources;
			}
		};

		return swaggerResourcesProvider;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
