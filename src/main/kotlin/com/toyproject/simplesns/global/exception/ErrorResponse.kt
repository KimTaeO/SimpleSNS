package com.toyproject.simplesns.global.exception

import com.toyproject.simplesns.global.exception.ErrorCode

class ErrorResponse(errorCode: ErrorCode) {
    val msg: String
    val code: Int

    init {
        msg = errorCode.msg
        code = errorCode.code
    }
}