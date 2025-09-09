package com.example.thymeleafdemo1.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Configuration class to set up internationalization (i18n) support.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configure the message source to load internationalization files.
     * The files should be named messages.properties, messages_en.properties, messages_fr.properties, etc.
     *
     * @return the configured MessageSource
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); // Path to resource bundle files
        messageSource.setDefaultEncoding("UTF-8"); // Encoding for message files
        messageSource.setCacheSeconds(3600); // Cache messages for 1 hour
        return messageSource;
    }

    /**
     * Configure the locale resolver to determine the current locale.
     * This example uses a session-based locale resolver with a default locale of US English.
     *
     * @return the configured LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US); // Default locale
        return localeResolver;
    }

    /**
     * Configure the locale change interceptor to allow changing the locale via a URL parameter.
     * The parameter name is set to "lang", so you can change the locale by adding ?lang=fr or ?lang=en to the URL.
     *
     * @return the configured LocaleChangeInterceptor
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang"); // URL parameter to change locale (e.g., ?lang=fr)
        return interceptor;
    }

    /**
     * Register the locale change interceptor with the application's interceptor registry.
     *
     * @param registry the InterceptorRegistry to which the interceptor is added
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}