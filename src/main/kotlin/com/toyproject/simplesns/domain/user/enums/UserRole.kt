package com.toyproject.simplesns.domain.user.enums

import org.springframework.security.core.GrantedAuthority

enum class UserRole : GrantedAuthority {
    ROLE_ADMIN, ROLE_USER, ROLE_ORGANIZATION;

    override fun getAuthority(): String =
        name
}