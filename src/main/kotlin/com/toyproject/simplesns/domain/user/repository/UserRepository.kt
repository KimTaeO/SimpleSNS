package com.toyproject.simplesns.domain.user.repository

import com.toyproject.simplesns.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): User?
    fun existsByPhoneNumberAndTag(phoneNumber: String, tag: String): Boolean
}