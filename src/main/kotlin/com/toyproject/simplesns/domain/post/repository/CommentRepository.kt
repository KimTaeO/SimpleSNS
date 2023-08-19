package com.toyproject.simplesns.domain.post.repository

import com.toyproject.simplesns.domain.post.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
}