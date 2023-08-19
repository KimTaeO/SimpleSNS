package com.toyproject.simplesns.domain.post.repository

import com.toyproject.simplesns.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
}