package com.toyproject.simplesns.domain.auth.service

import com.toyproject.simplesns.domain.auth.entity.RefreshToken
import com.toyproject.simplesns.domain.auth.exception.PasswordMismatchException
import com.toyproject.simplesns.domain.auth.presentation.dto.request.SignInRequest
import com.toyproject.simplesns.domain.auth.presentation.dto.response.SignInResponse
import com.toyproject.simplesns.domain.auth.repository.RefreshTokenRepository
import com.toyproject.simplesns.domain.user.repository.UserRepository
import com.toyproject.simplesns.global.exception.exceptions.UserNotFoundException
import com.toyproject.simplesns.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.ZonedDateTime


@Service
class SignInService(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder
) {
    fun execute(signInRequest: SignInRequest): SignInResponse {
        val user = userRepository.findByPhoneNumber(signInRequest.id) ?: throw UserNotFoundException()

        if(!passwordEncoder.matches(signInRequest.password, user.password))
            throw PasswordMismatchException()

        val (access, refresh) = jwtProvider
            .run { generateAccessToken(signInRequest.id) to generateRefreshToken(signInRequest.id) }

        val refreshToken = RefreshToken(
            userId = user.id,
            refreshToken = refresh
        )

        refreshTokenRepository.save(refreshToken)

        val expiredAt = jwtProvider.getAccessExpiredTime()

        return SignInResponse(
            accessToken = access,
            refreshToken = refresh,
            expiredAt = expiredAt
        )
    }
}