package com.toyproject.simplesns.domain.user.repository

import com.toyproject.simplesns.domain.user.entity.Follow
import com.toyproject.simplesns.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface FollowRepository : JpaRepository<Follow, Long> {
    fun existsByFollowerAndFollowing(follower: User, following: User): Boolean

    @Modifying
    @Query("DELETE FROM Follow f WHERE f.follower = :follower AND f.following = :following")
    fun deleteByFollowerAndFollowing(follower: User, following: User)
}