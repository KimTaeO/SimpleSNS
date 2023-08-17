package com.toyproject.simplesns.domain.entity

import com.toyproject.simplesns.domain.enums.UserRole
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val name: String,

    val password: String,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "UserRole", joinColumns = [JoinColumn(name = "id")])
    val userRole: MutableList<UserRole> = mutableListOf()
)