package com.toyproject.simplesns.domain.post.presentation

import com.toyproject.simplesns.domain.post.presentation.dto.request.CreatePostRequest
import com.toyproject.simplesns.domain.post.service.ChangeVisibilityFalseService
import com.toyproject.simplesns.domain.post.service.ChangeVisibilityTrueService
import com.toyproject.simplesns.domain.post.service.CreatePostService
import com.toyproject.simplesns.domain.post.service.DeletePostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
    private val createPostService: CreatePostService,
    private val changeVisibilityTrueService: ChangeVisibilityTrueService,
    private val changeVisibilityFalseService: ChangeVisibilityFalseService,
    private val deletePostService: DeletePostService
) {
    @PostMapping
    fun createPost(@RequestBody createPostRequest: CreatePostRequest): ResponseEntity<Void> {
        createPostService.execute(createPostRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PatchMapping("/{post_id}")
    fun changeVisibilityTrue(@PathVariable("post_id") postId: Long): ResponseEntity<Void> {
        changeVisibilityTrueService.execute(postId)
        return ResponseEntity(HttpStatus.OK)
    }

    @PatchMapping("/{post_id}")
    fun changeVisibilityFalse(@PathVariable("post_id") postId: Long): ResponseEntity<Void> {
        changeVisibilityFalseService.execute(postId)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/{post_id}")
    fun deletePost(@PathVariable("post_id") postId: Long): ResponseEntity<Void> {
        deletePostService.execute(postId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}