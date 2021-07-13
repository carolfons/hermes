package com.inatel.hermes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configuração de acesso de ongs.
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/ongs/**").permitAll()
				.antMatchers(HttpMethod.POST, "/ongs/**").hasRole("ADMIN").antMatchers(HttpMethod.PUT, "/ongs/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.DELETE, "/ongs/**").hasRole("ADMIN").and().csrf().disable()
				.formLogin().disable();

		// configurando acesso de usuarios pelos proprios usuarios
		http.cors().and().authorizeRequests().antMatchers(HttpMethod.GET, "/usuarios/**").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.POST, "/usuarios/**").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "/usuarios/**").hasAnyRole("ADMIN", "USER")
				.antMatchers(HttpMethod.DELETE, "/usuarios/**").hasRole("ADMIN").and().csrf().disable().formLogin()
				.disable();

		// autorização pra acessar o banco de dados pelos admins
		http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/console/**")
				.hasRole("ADMIN");
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/images/**");
	}

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST", "PUT",
				"DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}

}
