package com.myapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myapp.common.intercepter.AccessInterceptor;

@Configuration
//@EnableWebMvc jsp를 사용하려면 불필요
public class InterceptorConfig implements WebMvcConfigurer{
 
	/* handler에서 인식 또는 제외 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**/*.do");
    	
    	/* 제외처리*/
    	// .excludePathPatterns("/**/*.js")
    	// .excludePathPatterns("/**/*.css")
    	// .excludePathPatterns("/**/*.png")
    	// .excludePathPatterns("/**/*.cfg")
    	// .excludePathPatterns("/**/*.gif")
    	// .excludePathPatterns("/**/*.jpg");
        //registry.addInterceptor(new TokenInterceptor()).order(1);
    }
    
    /* static폴더외의 정적자원 인식시키기 */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
    }
}