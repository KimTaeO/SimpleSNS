package com.toyproject.simplesns.domain.post.service

import com.toyproject.simplesns.domain.post.exception.PostNotFoundException
import com.toyproject.simplesns.domain.post.repository.PostRepository
import com.toyproject.simplesns.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class DeletePostService(
    private val postRepository: PostRepository,
    private val userUtil: UserUtil
) {
    fun execute(id: Long) {
        val post = postRepository.findByIdAndUser(id, userUtil.fetchCurrentUser()) ?: throw PostNotFoundException()
        
        postRepository.delete(post)
    }
}