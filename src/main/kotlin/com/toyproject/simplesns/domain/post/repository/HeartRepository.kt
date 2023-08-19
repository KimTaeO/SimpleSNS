package com.toyproject.simplesns.domain.post.repository

import com.toyproject.simplesns.domain.post.entity.Heart
import org.springframework.data.jpa.repository.JpaRepository

interface HeartRepository : JpaRepository<Heart, Long> {
}