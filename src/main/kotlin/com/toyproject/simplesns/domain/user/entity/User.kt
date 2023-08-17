package com.toyproject.simplesns.domain.user.entity

import com.toyproject.simplesns.domain.user.enums.UserRole
import com.toyproject.simplesns.global.entity.BaseEntity
import javax.persistence.*

@Entity
class User(
    override val id: Long = 0L,

    val name: String,

    val phoneNumber: String,

    val tag: String,

    val password: String,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "UserRole", joinColumns = [JoinColumn(name = "id")])
    val userRole: MutableList<UserRole> = mutableListOf()
): BaseEntity(id)