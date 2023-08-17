package com.toyproject.simplesns.global.exception.exceptions

import com.toyproject.simplesns.global.exception.ErrorCode

class UserNotFoundException : BasicException(ErrorCode.USER_NOT_FOUND)