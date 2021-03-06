package com.ourteam.pcd.Configurations;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.ourteam.pcd.Services"})
@Import({ PcdPersistenceConfig.class })
public class PcdConfig {

	

	@Bean
	public PropertySourcesPlaceholderConfigurer propertyConfigurer() throws IOException {
		PropertySourcesPlaceholderConfigurer props = new PropertySourcesPlaceholderConfigurer();
		return props;
	}

}
