package com.toyproject.simplesns.domain.user.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class AlreadyFollowingException : BasicException(ErrorCode.ALREADY_FOLLOWING_EXCEPTION) {
}