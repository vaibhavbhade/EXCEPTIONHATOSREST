package com.atyeti.rest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
	AcceptHeaderLocaleResolver LocaleResolver =new AcceptHeaderLocaleResolver();
	LocaleResolver.setDefaultLocale(Locale.US);
		return LocaleResolver;
	}
	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages"); return messageSource;
	 * 
	 * }
	 */

}
