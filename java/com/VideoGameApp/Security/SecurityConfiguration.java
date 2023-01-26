package com.VideoGameApp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/home").hasAnyRole("USER")
			.antMatchers("/get-games/**").hasAnyRole("USER")
			.antMatchers("/Create/Videogame/**").hasAnyRole("USER")
			.antMatchers("/View/**").hasAnyRole("USER")
			.antMatchers("/register").anonymous()
			.antMatchers("/js/**", "/css/**").permitAll()
			.anyRequest().authenticated().and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/home", true)
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/login?logout")
			.permitAll();
	}
}
