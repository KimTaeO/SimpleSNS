package com.toyproject.simplesns.domain.auth.entity

import com.toyproject.simplesns.global.security.jwt.JwtProvider
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import javax.persistence.Id

@RedisHash(value = "RefreshToken", timeToLive = JwtProvider.REFRESH_EXP)
class RefreshToken(
    @Id
    @Indexed
    val userId: Long,

    @Indexed
    val refreshToken: String
)