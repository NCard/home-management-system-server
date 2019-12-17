package com.vgchicken.homeManagementSystemServer.controller

import com.vgchicken.homeManagementSystemServer.models.api.BaseResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping(value = ["/test", "/test/"])
class ConnectTestController {

    @GetMapping("")
    fun testConnect(): BaseResponse {
        return BaseResponse()
    }
}