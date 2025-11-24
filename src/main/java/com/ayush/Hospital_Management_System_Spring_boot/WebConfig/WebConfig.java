package com.ayush.Hospital_Management_System_Spring_boot.WebConfig; // Check your package name!

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins(
                    "http://localhost:5173", // For your local testing
                    "https://hospital-management-system-frontend-lovat.vercel.app", // Your Vercel App
                    "https://hospital-management-system-frontend-git-main-officialayushyadav1234.vercel.app" // Alternative Vercel link
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these actions
                .allowedHeaders("*")
                .allowCredentials(true); // Important for some browsers
    }
}