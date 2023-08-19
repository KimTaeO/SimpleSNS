package com.toyproject.simplesns.domain.post.presentation

import com.toyproject.simplesns.domain.post.presentation.dto.request.CreatePostRequest
import com.toyproject.simplesns.domain.post.service.CreatePostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
    private val createPostService: CreatePostService
) {
    fun createPost(@RequestBody createPostRequest: CreatePostRequest): ResponseEntity<Void> {
        createPostService.execute(createPostRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }
}