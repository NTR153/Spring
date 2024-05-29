package com.ntr153.telusko.springbootweb1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(@SuppressWarnings("null") ViewResolverRegistry registry) {
        // registry.jsp("/WEB-INF/jsp/", ".jsp");
        // System.out.println("In configure View");
        // This location was configured for jsp to override any and every property.
        // But didn't work :(
    }
}