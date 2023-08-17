package com.toyproject.simplesns.global.security.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class InvalidTokenException : BasicException(ErrorCode.INVALID_TOKEN) {
}