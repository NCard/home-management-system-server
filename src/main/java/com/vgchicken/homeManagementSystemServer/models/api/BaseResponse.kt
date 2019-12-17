package com.vgchicken.homeManagementSystemServer.models.api

import com.vgchicken.homeManagementSystemServer.models.ResponseCode


class BaseResponse(
        var responseCode: ResponseCode = ResponseCode.S001
)