package com.pchr.config;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.pchr.jwt.JwtFilter;
import com.pchr.jwt.TokenProvider;
import com.pchr.repository.TokenDataRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> 인터페이스를 구현하는 구현체다.
//직접 만든 TokenProvider와 JwtFilter를 SecurityConfig에 적용할 때 사용한다.
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final TokenProvider tokenProvider;
    private final  TokenDataRepository tokenDataRepository;
//메인 메소드인 configure은TokenProvider , tokenDataRepository를 주입받아서 JwtFilter를 통해 
//SecurityConfig 안에 필터를 등록하게 되고, 스프링 시큐리티 전반적인 필터에 적용된다.
    @Override
    public void configure(HttpSecurity http) {
    	JwtFilter customFilter = new JwtFilter(tokenProvider,tokenDataRepository);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}