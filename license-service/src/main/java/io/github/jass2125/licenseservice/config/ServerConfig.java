package io.github.jass2125.licenseservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig {
	
	private final String property = "dev";
	
	public String getProperty() {
		return property;
	}
	
}
