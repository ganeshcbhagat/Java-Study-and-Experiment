package com.atmosphere.gotcha.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/*@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "documentation.swagger.services")*/
public class SwaggerServices {
	
	private String name;
	private String url;
	private String version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "SwaggerServices [name=" + name + ", url=" + url + ", version=" + version + "]";
	}

}