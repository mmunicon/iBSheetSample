package com.myapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myapp.common.intercepter.AccessInterceptor;

@Configuration
//@EnableWebMvc jsp�� ����Ϸ��� ���ʿ�
public class InterceptorConfig implements WebMvcConfigurer{
 
	/* handler���� �ν� �Ǵ� ���� */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**/*.do");
    	
    	/* ����ó��*/
    	// .excludePathPatterns("/**/*.js")
    	// .excludePathPatterns("/**/*.css")
    	// .excludePathPatterns("/**/*.png")
    	// .excludePathPatterns("/**/*.cfg")
    	// .excludePathPatterns("/**/*.gif")
    	// .excludePathPatterns("/**/*.jpg");
        //registry.addInterceptor(new TokenInterceptor()).order(1);
    }
    
    /* static�������� �����ڿ� �νĽ�Ű�� */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
    }
}