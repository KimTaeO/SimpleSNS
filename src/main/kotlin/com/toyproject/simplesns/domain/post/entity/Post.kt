package com.toyproject.simplesns.domain.post.entity

import com.toyproject.simplesns.domain.user.entity.User
import com.toyproject.simplesns.global.entity.BaseEntity
import javax.persistence.*

@Entity
class Post(
    override val id: Long = 0L,

    val content: String,

    var visibility: Boolean = true,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "img", joinColumns = [JoinColumn(name = "id")])
    val imgUrls: List<String>
) : BaseEntity(id)