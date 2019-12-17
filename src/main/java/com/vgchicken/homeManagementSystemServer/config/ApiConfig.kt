package com.vgchicken.homeManagementSystemServer.config

import com.vgchicken.homeManagementSystemServer.controller.TokenInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@ComponentScan("com.vgchicken.homeManagementSystemServer")
open class ApiConfig: WebMvcConfigurer {

    @Bean
    open fun tokenInterceptor(): TokenInterceptor{
        return TokenInterceptor()
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(TokenInterceptor())
        super.addInterceptors(registry)
    }
}
