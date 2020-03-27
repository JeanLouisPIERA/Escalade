package fr.jeanlouispiera.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        PasswordEncoder encoder = 
	          PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        auth
	          .inMemoryAuthentication()
	          .withUser("Bob")
	          .password(encoder.encode("user"))
	          .roles("USER")
	          .and()
	          .withUser("Bobby")
	          .password(encoder.encode("admin"))
	          .roles("USER", "ADMIN");
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
           .antMatchers("/", "/*sites*/**").access("hasRole('USER')").and()
           .formLogin();

       http.csrf().disable();
       http.headers().frameOptions().disable();
	    }
}
