package com.atmosphere.gotcha.spring.config;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.Application;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/*@Component
@Primary
@EnableAutoConfiguration*/
//public class SwaggerResourcesProviderImpl implements SwaggerResourcesProvider {
public class SwaggerResourcesProviderImpl {
		
	@Autowired
	private SwaggerServicesConfig swaggerServiceList;

	/*@Autowired
    private DiscoveryClient discoveryClient;*/
	
	//@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		
		resources.add(swaggerResource("FOREX-SERVICE", "/v2/api-docs?group=Forex_Micro_Service_Group", "2.0"));
		resources.add(swaggerResource("CURRENCY-CONVERSION-SERVICE", "/v2/api-docs?group=Currency_Exchange_Micro_Service_Group", "2.0"));
		
		 /*swaggerServiceList.getServices().forEach(new Consumer<SwaggerServices>() {
			@Override
			public void accept(SwaggerServices service) {
				System.out.println(service);
				resources.add(swaggerResource(service.getName(), service.getUrl(), service.getVersion()));
			}
		 });*/
		 
		/* System.out.println("---------------------------------------------------");
		List<Application> litsOfRegisteredApplication = discoveryClient.getApplications().getRegisteredApplications();
		litsOfRegisteredApplication.forEach( new Consumer<Application>() {
			@Override
			public void accept(Application application) {
				InstanceInfo instanceInfo = application.getByInstanceId(application.getName());
				System.out.println(application.getName()+" "+instanceInfo.getHomePageUrl());
				//resources.add(swaggerResource(application.getName(), instanceInfo.getHomePageUrl(), "2.0"));
			}
		 });
		System.out.println("---------------------------------------------------");*/
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
