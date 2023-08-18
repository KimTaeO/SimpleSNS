package com.toyproject.simplesns.domain.auth.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class PasswordMismatchException : BasicException(ErrorCode.PASSWORD_MISMATCH){
}