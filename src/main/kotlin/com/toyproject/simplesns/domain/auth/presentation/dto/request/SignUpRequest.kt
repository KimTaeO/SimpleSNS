package com.toyproject.simplesns.domain.auth.presentation.dto.request

data class SignUpRequest(
    val name: String,
    val phoneNumber: String,
    val tag: String,
    val password: String,
)