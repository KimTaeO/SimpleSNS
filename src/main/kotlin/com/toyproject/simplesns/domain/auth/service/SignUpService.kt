package com.toyproject.simplesns.domain.auth.service

import com.toyproject.simplesns.domain.auth.exception.DuplicatePhoneNumberOrTagException
import com.toyproject.simplesns.domain.auth.presentation.dto.request.SignUpRequest
import com.toyproject.simplesns.domain.user.entity.User
import com.toyproject.simplesns.domain.user.enums.UserRole
import com.toyproject.simplesns.domain.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class SignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun execute(signUpRequest: SignUpRequest) {
        if(userRepository.existsByPhoneNumberAndTag(signUpRequest.phoneNumber, signUpRequest.tag))
            throw DuplicatePhoneNumberOrTagException()

        val encodedPassword = passwordEncoder.encode(signUpRequest.password)

        val user = User(
            name = signUpRequest.name,
            tag = signUpRequest.tag,
            phoneNumber = signUpRequest.phoneNumber,
            password = encodedPassword
        )

        user.userRole.add(UserRole.ROLE_USER)

        userRepository.save(user)
    }
}