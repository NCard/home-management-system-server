package com.vgchicken.homeManagementSystemServer.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@SpringBootApplication
@EnableJpaRepositories("com.vgchicken.homeManagementSystemServer")
@EntityScan("com.vgchicken.homeManagementSystemServer.sql.models")
@EnableTransactionManagement
open class Application: SpringBootServletInitializer() {

    fun main(args: Array<String>) {
        SpringApplication.run(Application::class.java, *args)
    }
}