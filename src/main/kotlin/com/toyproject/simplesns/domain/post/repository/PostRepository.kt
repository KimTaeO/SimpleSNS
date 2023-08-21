package com.toyproject.simplesns.domain.post.repository

import com.toyproject.simplesns.domain.post.entity.Post
import com.toyproject.simplesns.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByIdAndUser(id: Long, user: User): Post?
}