package com.dbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dbs.web.filter.JwtRequestFilter;
import com.dbs.web.service.AccountUserDetailsService;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@EnableWebSecurity
@SecurityScheme(scheme = "bearer", 
name="api",
type = SecuritySchemeType.HTTP, 
in = SecuritySchemeIn.HEADER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private AccountUserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}
	/**
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("abc").password(encoder().encode("abc")).roles("USER")
		.and()
		.withUser("admin").password(encoder().encode("admin")).roles("ADMIN");
	}
	*/
	
	 
    private static final String[] AUTH_WHITELIST = {
        // -- Swagger UI v2
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**",
        // -- Swagger UI v3 (OpenAPI)
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/","/products/**","/actuator/**"
        , "/admin/**","/register","/test"
        // other public endpoints of your API may be appended to this array
};
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * Disable CSRF and authorize any other requests using form based authentication
		 */
		//http.csrf().disable()
		//.authorizeRequests().anyRequest().authenticated()
		//.and().formLogin().and().logout();
		
		/**
		 * Disable CSRF and permit the urls passed without authentication
		 * and authorize any other requests using form based authentication.
		 
		 */
		//http.csrf().disable()
		//.authorizeRequests().antMatchers(HttpMethod.GET,"/","/products/**").permitAll()
		//.anyRequest().authenticated()
		//.and().formLogin().and().logout();
		
		/**
		 * 
		 * Disable CSRF and permit the urls passed without authentication
		 * and permit few urls for admin and user 
		 * and permit only few urls for admin
		 * and authorize any other requests using form based authentication.
		 */
		
		//spring mvc
		//http.csrf().disable()
		//whitelist array for all
		//.authorizeRequests().antMatchers(HttpMethod.GET,AUTH_WHITELIST).permitAll()
		//.and()
		//.authorizeRequests()
		//.antMatchers("/invoices/**", "/sigin","/dashboard","/invoice")
		//.hasAnyRole("USER","ADMIN")
		//.antMatchers(HttpMethod.POST,"/products").hasAnyRole("ADMIN")
		//.antMatchers("/user").hasAnyRole("ADMIN")
		//.anyRequest().authenticated().and()
		//.formLogin().and().logout();
		

		// jwt
		 http.csrf().disable()
		.authorizeRequests()//whitelist
		.antMatchers(HttpMethod.GET,AUTH_WHITELIST)
		.anonymous()
		.antMatchers(HttpMethod.POST, "/authenticate")
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/message", "/swagger-ui.html")
		.permitAll()
		.antMatchers(HttpMethod.POST,"/transaction").hasAnyRole("ADMIN")
		.antMatchers("/user").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.disable().cors();
		 
		 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Autowired
	private JwtRequestFilter jwtFilter;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/h2-console/**");
	}
	/*
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}*/
 
}
