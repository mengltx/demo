package com.pose.demo.config

import com.pose.demo.service.AuthorityService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import com.pose.demo.security.MyFilterSecurityInterceptor
import org.springframework.beans.factory.annotation.Autowired





/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:12:10
 *
 * */
@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter(){

    @Autowired
    lateinit var myFilterSecurityInterceptor: MyFilterSecurityInterceptor

    @Bean
    fun authorityService():AuthorityService{
        return AuthorityService()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(authorityService())
    }

    override fun configure(http: HttpSecurity?) {


        http!!.authorizeRequests().antMatchers("/css/**").permitAll()
                .anyRequest().permitAll() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
               .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll() //注销行为任意访问
                .and().csrf().disable()


        //http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor::class.java)

       // http!!.authorizeRequests().anyRequest().permitAll();
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance();
    }

}