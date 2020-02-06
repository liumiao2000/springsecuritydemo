package com.securitytest.test.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService = null;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		/*
		http.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/mylogin/page")
				.loginProcessingUrl("/login")
				.successHandler(new AuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(
						HttpServletRequest request, 
						HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
						response.setContentType("application/json;charset=UTF-8");
						response.getWriter().write("{\"error_code\":0,\"message\":\"欢迎登陆系统\"}");
					}
					
				})
				.failureHandler(new AuthenticationFailureHandler() {

					@Override
					public void onAuthenticationFailure(
						HttpServletRequest request, 
						HttpServletResponse response,
						AuthenticationException e) throws IOException, ServletException {
						response.setContentType("application/json;charset=UTF-8");
						response.setStatus(401);
						response.getWriter().write("{\"error_code\":0,\"name\":\""+e.getClass()+"\",\"message\":\""+e.getMessage()+"\"}");
						
					}
					
				})
				.permitAll()
			.and()
			.csrf().disable();
		*/
		http.authorizeRequests()
			.antMatchers("/admin/api/**").hasRole("ADMIN")
			.antMatchers("/user/api/**").hasRole("USER")
			.antMatchers("/app/api/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
		//super.configure(auth);
	}
	
}
