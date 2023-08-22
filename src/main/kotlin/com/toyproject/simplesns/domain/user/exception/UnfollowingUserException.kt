package com.toyproject.simplesns.domain.user.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class UnfollowingUserException : BasicException(ErrorCode.UNFOLLOWING_USER_EXCEPTION){
}