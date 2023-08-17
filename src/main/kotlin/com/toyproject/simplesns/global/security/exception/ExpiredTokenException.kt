package com.toyproject.simplesns.global.security.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class ExpiredTokenException : BasicException(ErrorCode.EXPIRED_TOKEN) {
}