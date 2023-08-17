package com.toyproject.simplesns.global.exception.exceptions

import com.toyproject.simplesns.global.exception.ErrorCode

open class BasicException(val errorCode: ErrorCode): RuntimeException(errorCode.msg)