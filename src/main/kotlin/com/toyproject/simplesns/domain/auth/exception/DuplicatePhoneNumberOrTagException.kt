package com.toyproject.simplesns.domain.auth.exception

import com.toyproject.simplesns.global.exception.ErrorCode
import com.toyproject.simplesns.global.exception.exceptions.BasicException

class DuplicatePhoneNumberOrTagException: BasicException(ErrorCode.DUPLICATE_PHONE_NUMBER_OR_TAG) {
}