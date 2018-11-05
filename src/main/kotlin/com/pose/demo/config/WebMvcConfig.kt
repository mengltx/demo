package com.pose.demo.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 *
 * Created with IDEA
 * author:zhandd
 * Date:2018/10/26
 * Time:14:28
 *
 * */
@Configuration
class WebMvcConfig: WebMvcConfigurer{
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/login").setViewName("login")
    }
}