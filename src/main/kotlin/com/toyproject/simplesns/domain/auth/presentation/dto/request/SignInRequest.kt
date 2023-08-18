package com.toyproject.simplesns.domain.auth.presentation.dto.request

data class SignInRequest(
    val id: String,
    val password: String
)