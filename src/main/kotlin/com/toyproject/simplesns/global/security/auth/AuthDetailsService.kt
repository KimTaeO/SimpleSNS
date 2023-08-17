package com.toyproject.simplesns.global.security.auth

import com.toyproject.simplesns.domain.user.repository.UserRepository
import com.toyproject.simplesns.global.exception.exceptions.UserNotFoundException
import com.toyproject.simplesns.global.security.auth.AuthDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByName(username) ?: throw UserNotFoundException()
        return AuthDetails(user)
    }

}