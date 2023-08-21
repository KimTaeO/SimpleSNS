package com.toyproject.simplesns.domain.user.repository

import com.toyproject.simplesns.domain.user.entity.Follow
import com.toyproject.simplesns.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<Follow, Long> {
    fun existsByFollowerAndFollowing(follower: User, following: User): Boolean
}