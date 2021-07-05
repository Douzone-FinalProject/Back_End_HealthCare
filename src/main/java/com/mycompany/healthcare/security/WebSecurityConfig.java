package com.mycompany.healthcare.security;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	// Injection
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 폼 인증을 비활성화
		http.httpBasic().disable();
		
		// 서버 세션 비활성화
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// CSRF 비활성화 (사이트간 요청 위조 방지 비활성화)
		http.csrf().disable();
		
		// CORS 활성화 (다른 도메인에서 요청을 허가), 스프링 관리 객체 중에서 이 메서드를 찾아서 처리하라는 뜻
		http.cors();
		
		// JWT 인증 필터를 추가
		http.addFilterBefore(new JwtAuthenticationFilter(userDetailsService),UsernamePasswordAuthenticationFilter.class);
		// 요청 경로 권한 설정
		http.authorizeRequests()
			.expressionHandler(securityExpressionHandler()) // 권한 계층 설정
			// 요청 경고 권한 설정
			
			// 그 이외의 모든 경로 허가
			.antMatchers("/**").permitAll();
	}
	
	// DataSource 설정
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select staff_login_id as username, staff_login_pwd as password, staff_enabled as enabled from staffs where staff_login_id=?")
        .authoritiesByUsernameQuery("select staff_login_id as username, staff_role as authority from staffs where staff_login_id=?")
        .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// 사용자의 상세 정보를 가져오는 서비스 객체를 관리 객체로 등록 > JwtAuthenticationFilter 사용
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	// 인증된 정보를 관리하는 객체를 Spring 관리 객체로 등록 -> AuthController에서 사용
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	// 권한 계층 설정 객체 생성
	public RoleHierarchyImpl roleHierarchyImpl() {
		RoleHierarchyImpl roleHierarchyImpl = new RoleHierarchyImpl();
		roleHierarchyImpl.setHierarchy("ROLE_DOCTOR > ROLE_NURSE");
		return roleHierarchyImpl;
	}
	
	public SecurityExpressionHandler<FilterInvocation> securityExpressionHandler() {
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchyImpl());
        return defaultWebSecurityExpressionHandler;
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		
		// 모든 요청 사이트 허용
		configuration.addAllowedOrigin("*");
		
		// 모든 요청 방식 허용 (GET, POST, PUT, DELETE)
		configuration.addAllowedMethod("*");
		
		// 모든 요청 헤더 허용
		configuration.addAllowedHeader("*");
		
		// 요청 헤더의 Authorization을 이용하여 사용자 인증(로그인 처리) 하지 않음 (httpBasic과 관련 있음)
		configuration.setAllowCredentials(false);
		
		// 모든 요청에 대하여 CORS를 세팅하겠다.
		// URL 요청하는 모든 내용에 대해서 적용한다.
		UrlBasedCorsConfigurationSource ccs = new UrlBasedCorsConfigurationSource();
		ccs.registerCorsConfiguration("/**", configuration);
		
		return ccs;
	}
	
	

}
