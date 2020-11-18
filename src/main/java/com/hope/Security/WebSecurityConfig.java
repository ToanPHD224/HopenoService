package com.hope.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/**").permitAll()
	                .antMatchers("/resources/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
		            // Cho phép người dùng xác thực bằng form login
	                .formLogin()
	                .usernameParameter("email")
	                .passwordParameter("psw")
	                .defaultSuccessUrl("/hello")
	                .permitAll() // Tất cả đều được truy cập vào địa chỉ này
	                .failureUrl("/login?error")
	                .and()
	                .logout()// Cho phép logout
	                .logoutSuccessUrl("/layout/index")
	                .permitAll()
	                .and()
	            .exceptionHandling()
	                .accessDeniedPage("/403");
	    }
}
