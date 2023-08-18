package com.toyproject.simplesns.domain.auth.repository

import com.toyproject.simplesns.domain.auth.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, Long> {
}