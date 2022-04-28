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

	// ���� �ڿ��� ���ؼ��� Security ������ �������� ����.
    // WebSecurity�� FilterChainProxy ���� �����Դϴ�.
    @Override
    public void configure(WebSecurity web) {
        // �ش� ����� ���ϵ��� spring security�� �����ϵ����մϴ�.
        //web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    	//System.out.println(PathRequest.toStaticResources().atCommonLocations().toString());
    	web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    	web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    
    /* �Ϲ� ���� �� ���� Ȯ�� */
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