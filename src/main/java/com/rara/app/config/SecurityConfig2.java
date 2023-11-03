package com.rara.app.config;

import com.rara.app.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@RequiredArgsConstructor
@Configuration
public class SecurityConfig2 {

    private final MemberDetailService memberDetailService;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers("/static/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests((req) -> req
                        .requestMatchers("/login", "/signup", "/api/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((fl) -> fl
                        .loginPage("/login")    // GET 요청 (login form을 보여줌)
                        .loginProcessingUrl("/auth")    // POST 요청 (login 창에 입력한 데이터를 처리)
                        .usernameParameter("email")    // login에 필요한 id 값을 email로 설정 (default는 username)
                        .passwordParameter("pwd")// login에 필요한 password 값을 password(default)로 설정
                        .defaultSuccessUrl("/")    // login에 성공하면 /로 redirect
                )
                .logout((lo) -> lo
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .logoutSuccessUrl("/")    // logout에 성공하면 /로 redirect
                )
                .csrf((csrf) -> csrf.disable())
                .build();
    }

    @Autowired
    private AuthenticationManagerBuilder authManagerBuilder;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}