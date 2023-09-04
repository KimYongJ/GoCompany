package com.pchr.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import com.pchr.jwt.JwtAccessDeniedHandler;
import com.pchr.jwt.JwtAuthenticationEntryPoint;
import com.pchr.jwt.TokenProvider;
import com.pchr.repository.TokenDataRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Component
public class WebSecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final  TokenDataRepository tokenDataRepository;
    //request로부터 받은 비밀번호를 암호화하기 위해 PasswordEncoder 빈을 생성했다.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	//WebSecurityConfigurerAdapter는 22년 해당 기능을 deprecated했다.
	//대신 HttpSecurity를 Configuring해서 사용하라는 대안방식을 제시
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
    			.authorizeRequests()
    	        .antMatchers("/api/auth/**").permitAll()
    	        .antMatchers("/api/user/newtoken").permitAll()
    	        .antMatchers("/api/user/**").access("hasRole('ADMIN') or hasRole('USER')or hasRole('MANAGER')")
    	        .antMatchers("/api/manager/**").access("hasRole('ADMIN') or hasRole('MANAGER')")
    	        .antMatchers("/api/admin/**").access("hasRole('ADMIN')")
    	        .anyRequest().authenticated()
    	        .and()
    	        .apply(new JwtSecurityConfig(tokenProvider,tokenDataRepository));
        http
                .csrf().disable()
                //또한 우리는 REST API를 통해 세션 없이 토큰을 주고받으며 데이터를 주고받기 때문에 세션설정또한 STATELESS로 설정했다.                
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                //이후 예외를 핸들링하는 것에서는 이전에 작성했던 JwtAuthenticationEntryPoint와 JwtAccessDeniedHandler를 넣었다.
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler);
        return http.build();
    }
}