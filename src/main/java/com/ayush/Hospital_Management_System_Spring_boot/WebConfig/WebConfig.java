package com.ayush.Hospital_Management_System_Spring_boot.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		        .allowedOrigins("mysql://avnadmin:AVNS_MIQTo4_NlJXf-cfcOKF@mysql-18b1aceb-officialayushyadav1234-d388.f.aivencloud.com:11090/defaultdb?ssl-mode=REQUIRED")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	}
}