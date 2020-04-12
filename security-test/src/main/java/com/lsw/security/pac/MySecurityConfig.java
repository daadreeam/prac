package com.lsw.security.pac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
// 只有开启这个注解才能让@preAuthorized生效
@EnableGlobalMethodSecurity(prePostEnabled=true)
//@EnableGlobalMethodSecurity
//@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/test/login") // 登录跳转 URL 没有权限之后的重定向页面
//                .loginPage("/login.html") // 登录跳转 URL 没有权限之后的重定向页面
                .loginProcessingUrl("/form") // 处理表单登录 URL
//                .successHandler(authenticationSucessHandler) // 处理登录成功
//                .failureHandler(authenticationFailureHandler) // 处理登录失败
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers(
                        "/test/noAuth","/test/login", "/login.html","/index.html").permitAll() // 登录跳转 URL 无需认证
//                .antMatchers("/who").hasRole("test")
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable();
    }
}
