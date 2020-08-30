package com.singularity.EamilClassifivationSystem.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.singularity.EamilClassifivationSystem.security.handlers.AccessDeniedHandlerImpl;
import com.singularity.EamilClassifivationSystem.security.handlers.AuthenticationFailureHandlerImpl;
import com.singularity.EamilClassifivationSystem.security.handlers.AuthenticationSuccessHandlerImpl;
import com.singularity.EamilClassifivationSystem.security.handlers.LogoutSuccessHandlerImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

//	@Autowired
//	private AuthenticationEntryPointImpl authenticationEntryPointImpl;

	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;

	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
//				 .anyRequest().authenticated()
				 .antMatchers(HttpMethod.GET,"/users/**").authenticated()
//				.anyRequest().permitAll()
				.and().exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl)
				// .authenticationEntryPoint(authenticationEntryPointImpl)
				.and().formLogin().usernameParameter("username").passwordParameter("password")
				.successHandler(authenticationSuccessHandlerImpl).failureHandler(authenticationFailureHandlerImpl).and()
				.logout().permitAll().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandlerImpl)
				.deleteCookies("JSESSIONID")
				.and()
				.httpBasic();
	}

	@Bean // put the return object into spring container, as a bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Autowired // @Autowired on function will autowired the parameters
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means
												// only this site can access.
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}