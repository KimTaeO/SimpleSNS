package com.toyproject.simplesns.domain.auth.presentation

import com.toyproject.simplesns.domain.auth.presentation.dto.request.SignInRequest
import com.toyproject.simplesns.domain.auth.presentation.dto.request.SignUpRequest
import com.toyproject.simplesns.domain.auth.presentation.dto.response.SignInResponse
import com.toyproject.simplesns.domain.auth.service.SignInService
import com.toyproject.simplesns.domain.auth.service.SignUpService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val signUpService: SignUpService,
    private val signInService: SignInService
) {
    @PostMapping("/sign_up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<Void> {
        signUpService.execute(signUpRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }
    @PostMapping
    fun signIn(@RequestBody signInRequest: SignInRequest): ResponseEntity<SignInResponse> {
        val result = signInService.execute(signInRequest)
        return ResponseEntity.ok(result)
    }
}