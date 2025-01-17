package com.everymatch.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.everymatch.mvc.intercepter.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	private final JwtInterceptor jwtInterceptor;
	
	public WebConfig(JwtInterceptor jwtInterceptor) {
		this.jwtInterceptor = jwtInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
			.excludePathPatterns("/api/user/**", "/swagger-ui/**", "/v3/api-docs/**");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedOrigins("http://localhost:8081")
				.allowedMethods("GET", "POST", "DELETE", "PUT");
	}
		
	@Bean
	RestTemplate openaiRestTemplate() {
		return new RestTemplate();
	}
	
}
