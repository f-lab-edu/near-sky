package com.dseoki;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ResourceLoader resourceLoader;

    @Value("${resource.image}")
    private String resourcePath;

    public WebConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String rootDir = new File("").getAbsolutePath();
        registry.addResourceHandler("/images/**")
                .addResourceLocations(resourcePath);
    }

}
