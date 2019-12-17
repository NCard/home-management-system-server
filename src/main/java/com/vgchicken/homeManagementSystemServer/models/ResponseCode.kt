package com.vgchicken.homeManagementSystemServer.models

import com.vgchicken.homeManagementSystemServer.models.api.BaseResponse
import java.lang.Exception
import java.lang.RuntimeException

//sealed class ResponseCode {
//    fun SUCCESS(message: String) = mutableMapOf("responseCode" to "S001", "message" to message)
//    fun ERROR() = mutableMapOf("responseCode" to "E001")
//}

enum class ResponseCode {
    S001 // success
}


