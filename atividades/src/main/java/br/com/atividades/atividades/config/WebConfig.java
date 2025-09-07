package br.com.atividades.atividades.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer
    ) {
        // EXTENSION.<url>.xml _.JSON Deprecated on Spring Boot 2.6
        // QUERY PARAM <url>?mediaType=xml

    }
}
