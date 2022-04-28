package com.myapp.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 정적 자원에 대해서는 Security 설정을 적용하지 않음.
    // WebSecurity는 FilterChainProxy 생성 필터입니다.
    @Override
    public void configure(WebSecurity web) {
        // 해당 경로의 파일들은 spring security가 무시하도록합니다.
        //web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    	//System.out.println(PathRequest.toStaticResources().atCommonLocations().toString());
    	web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    	web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    
    /* 일반 인증 및 권한 확인 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    	
        http.authorizeRequests()
                .antMatchers("/member/**").authenticated()
                .antMatchers("/admin/**").authenticated()
                .antMatchers("/webapp/**").permitAll()
                .antMatchers("/**").permitAll();
        http.formLogin().disable();        
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);

        http.exceptionHandling()
                .accessDeniedPage("/denied");
    }
/*
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
*/
}