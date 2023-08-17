package com.toyproject.simplesns.domain.auth.presentation

import com.toyproject.simplesns.domain.auth.presentation.dto.request.SignUpRequest
import com.toyproject.simplesns.domain.auth.service.SignUpService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val signUpService: SignUpService
) {
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<Void> {
        signUpService.execute(signUpRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }
}