package com.toyproject.simplesns.domain.user.service

import com.toyproject.simplesns.domain.user.exception.UnfollowingUserException
import com.toyproject.simplesns.domain.user.repository.FollowRepository
import com.toyproject.simplesns.domain.user.repository.UserRepository
import com.toyproject.simplesns.domain.user.util.UserUtil
import com.toyproject.simplesns.global.exception.exceptions.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class UnFollowService(
    private val userRepository: UserRepository,
    private val followRepository: FollowRepository,
    private val userUtil: UserUtil
) {
    fun execute(id: Long) {
        val user = userRepository.findByIdOrNull(id) ?: throw UserNotFoundException()
        val currentUser = userUtil.fetchCurrentUser()

        try {
        followRepository.deleteByFollowerAndFollowing(user, currentUser)
        } catch (e: UnfollowingUserException) {
            throw e
        }
    }
}