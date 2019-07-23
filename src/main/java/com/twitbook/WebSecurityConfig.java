package com.twitbook;

import com.twitbook.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.customUserDetailService);
    }

    //자원 접근 푸는 법(경로는 맞는지 모르겠음...지금은 자원이 없어서 주석처리 함)
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**")
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeRequests()
                    //admin 계정 접근 처리(지금은 Admin계정, 페이지 없어서 주석처리 함)
                    //.antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/**").permitAll()
                    //.antMatchers("/account/**").hasRole("USER")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    //.defaultSuccessUrl("/")
                    //.usernameParameter("account_email")
                    //.passwordParameter("account_password")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login");
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .authenticationProvider(authenticationProvider)
//                .inMemoryAuthentication()
//                    .withUser("account_email")
//                    .password("account_password")
//                    .roles("USER");
//    }
}
