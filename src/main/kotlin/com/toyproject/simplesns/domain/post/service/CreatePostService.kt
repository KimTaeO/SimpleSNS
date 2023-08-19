package com.toyproject.simplesns.domain.post.service

import com.toyproject.simplesns.domain.post.entity.Post
import com.toyproject.simplesns.domain.post.presentation.dto.request.CreatePostRequest
import com.toyproject.simplesns.domain.post.repository.PostRepository
import com.toyproject.simplesns.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class CreatePostService(
    private val postRepository: PostRepository,
    private val userUtil: UserUtil
) {
    fun execute(createPostRequest: CreatePostRequest) {
        val user = userUtil.fetchCurrentUser()

        val post = Post(
            content = createPostRequest.content,
            user = user,
            imgUrls = createPostRequest.imgUrls
        )

        postRepository.save(post)
    }
}