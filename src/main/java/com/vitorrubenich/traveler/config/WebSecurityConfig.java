package com.vitorrubenich.traveler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.vitorrubenich.traveler.services.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	
	/*
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests((requests) -> requests
			.antMatchers("/", "/index","/destinos","/contato","/promocoes","/imagempromo/**","/imagemdestino/**", "/img/**", "/styles/**", "/js/**").permitAll()
			.anyRequest().permitAll() //authenticated() //permitAll()
			)
			.formLogin((form) -> form
			.loginPage("/login")
			.defaultSuccessUrl("/clientes")
			.permitAll()
			)
			.logout((logout) -> logout.permitAll());
		http.rememberMe()
        .key("chaverememberMe");
		return http.build();
	}

	*/
	@Bean
	  public AuthenticationProvider daoAuthenticationProvider() {
	    DaoAuthenticationProvider provider = 
	      new DaoAuthenticationProvider();
	    provider.setPasswordEncoder(passwordEncoder());
	    provider.setUserDetailsService(this.userDetailsService());
	    return provider;
	  }
	
	@Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((requests) -> requests
		.antMatchers("/", "/index","/destinos","/contato","/promocoes","/imagempromo/**","/imagemdestino/**", "/img/**", "/styles/**", "/js/**").permitAll()
		.anyRequest().permitAll() //authenticated() //permitAll()
		);
		http.formLogin().loginProcessingUrl("/userAuth")
        .loginPage("/login")
        .defaultSuccessUrl("/clientes")
        .permitAll();

    http.logout()
        .logoutRequestMatcher(
            new AntPathRequestMatcher("/logout", "GET")
        )
        .logoutSuccessUrl("/login");

    http.rememberMe()
        .key("chaverememberMe");


	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}


}