package com.example.helloworld;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.helloworld.service.MongoUserDetailsService;

@Configuration
@EnableConfigurationProperties
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MongoUserDetailsService userDetailsService;
	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
//	}
	@Bean
	 public CorsConfigurationSource corsConfigurationSource() {
	  final CorsConfiguration configuration = new CorsConfiguration();
	  configuration.setAllowedOrigins(Arrays.asList("*"));
	  configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
	  configuration.setAllowCredentials(true);
	  configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
	  final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	  source.registerCorsConfiguration("/**", configuration);
	  return source;
	 }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	  	.cors().and()
	    .csrf().disable()	    
	    .authorizeRequests()
	    .anyRequest().authenticated().and()
	    .logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
	    .and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
	 builder.userDetailsService(userDetailsService);
	}
}
