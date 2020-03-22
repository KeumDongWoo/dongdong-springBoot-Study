package com.dongdong.springboot.config.auth;

import com.dongdong.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //spring security 설정을 활성
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .headers().frameOptions().disable() //  h2-console 화면을 사용하기위해 해당 옵션들을 disabled
                .and()
                    .authorizeRequests() //URL별 권한 관리를 설정
                    .antMatchers("/","/CSS/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //관리권한 대상설정
                    .anyRequest().authenticated() //설정된값 이외 나머지 URL 설정
                .and()
                    .logout()
                        .logoutSuccessUrl("/")  //로그아웃 성공시 루트로 이동
                .and()
                    .oauth2Login() //Oauth2 로그인 기능에 대한 여러설정의 진입점
                        .userInfoEndpoint() //Oauth2 로그인 성공 이후 사용자 정보를 가져올때 설정
                            .userService(customOAuth2UserService);// 소셜 로그인 성공시 userService 인터페이스의 구현체를 등록
    }
}
