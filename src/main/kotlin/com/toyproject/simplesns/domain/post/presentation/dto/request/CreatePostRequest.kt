package com.toyproject.simplesns.domain.post.presentation.dto.request

import reactor.util.annotation.NonNull

data class CreatePostRequest(
    @NonNull
    val content: String,

    val imgUrls: List<String>
)