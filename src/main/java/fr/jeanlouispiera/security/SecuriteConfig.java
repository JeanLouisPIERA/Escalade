package fr.jeanlouispiera.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	//private DataSource dataSource;
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        PasswordEncoder encoder = 
	          PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        auth
	          .inMemoryAuthentication()
	          .withUser("user1")
	          .password(encoder.encode("user"))
	          .roles("USER")
	          .and()
	          .withUser("admin1")
	          .password(encoder.encode("admin"))
	          .roles("USER", "ADMIN");
	        /**
	        auth
	        .jdbcAuthentication()
	        .dataSource(dataSource)
	        .usersByUsernameQuery("select username as principal, password as credentials from users where username=? ")
	        .authoritiesByUsernameQuery("select usename as principal, role as role from users_roles where username = ?")
	        .rolePrefix("ROLE_")
	        .passwordEncoder(encoder);**/
	 }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.formLogin().loginPage("/login");
	    	http.authorizeRequests().antMatchers("/login", "/", "/css/**", "/webjars/**", "/bootstrap/**").permitAll();
	    	http.authorizeRequests().antMatchers("/user/**").hasAnyRole("USER", "ADMIN");
	    	http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
	    	
	    	
	    	
	    }
}
