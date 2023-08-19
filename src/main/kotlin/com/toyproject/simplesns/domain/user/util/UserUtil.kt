package com.toyproject.simplesns.domain.user.util

import com.toyproject.simplesns.domain.user.entity.User
import com.toyproject.simplesns.domain.user.repository.UserRepository
import com.toyproject.simplesns.global.exception.exceptions.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserUtil(
    private val userRepository: UserRepository
) {
    fun fetchCurrentUser(): User {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val phoneNumber = principal.toString()
        return fetchUserByPhoneNumber(phoneNumber)
    }

    private fun fetchUserByPhoneNumber(phoneNum: String): User =
        userRepository.findByPhoneNumber(phoneNum) ?: throw UserNotFoundException()

}