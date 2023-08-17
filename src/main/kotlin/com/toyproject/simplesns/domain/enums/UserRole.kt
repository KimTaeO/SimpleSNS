package com.toyproject.simplesns.domain.enums

import org.springframework.security.core.GrantedAuthority

enum class UserRole : GrantedAuthority {
    ROLE_ADMIN, ROLE_USER;

    override fun getAuthority(): String =
        name
}