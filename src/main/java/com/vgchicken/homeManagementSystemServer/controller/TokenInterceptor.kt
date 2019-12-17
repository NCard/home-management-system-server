package com.vgchicken.homeManagementSystemServer.controller

import com.vgchicken.homeManagementSystemServer.models.Token
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.servlet.HandlerInterceptor
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@CrossOrigin(origins = ["*"])
open class TokenInterceptor : HandlerInterceptor {

    @CrossOrigin(origins = ["*"])
    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        if (request.method == "OPTIONS") return true
        val token = Token(request.getHeader("token"))

        return if (token.realToken == "" || token.realToken == null || token.date == null) {
            response.writer.print("{\"responseCode\":\"E001\"}")
            response.contentType = "application/json"
            false
        } else true
    }
}

