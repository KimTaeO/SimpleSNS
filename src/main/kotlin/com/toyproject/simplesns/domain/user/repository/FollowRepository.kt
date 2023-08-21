package com.toyproject.simplesns.domain.user.repository

import com.toyproject.simplesns.domain.user.entity.Follow
import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<Follow, Long> {
}