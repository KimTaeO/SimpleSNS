package com.toyproject.simplesns.global.security.auth

import com.toyproject.simplesns.domain.user.repository.UserRepository
import com.toyproject.simplesns.global.exception.exceptions.UserNotFoundException
import com.toyproject.simplesns.global.security.auth.AuthDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(phoneNumber: String): UserDetails {
        val user = userRepository.findByPhoneNumber(phoneNumber) ?: throw UserNotFoundException()
        return AuthDetails(user)
    }

}