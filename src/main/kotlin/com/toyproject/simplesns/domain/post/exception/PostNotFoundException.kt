package com.toyproject.simplesns.domain.post.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class PostNotFoundException : BasicException(ErrorCode.POST_NOT_FOUND) {
}