package com.toyproject.simplesns.domain.post.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class VisibilityNotMatchException : BasicException(ErrorCode.VISIBILITY_NOT_MATCH_EXCEPTION) {
}