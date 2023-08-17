package com.toyproject.simplesns.domain.repository

import com.toyproject.simplesns.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): User?
}