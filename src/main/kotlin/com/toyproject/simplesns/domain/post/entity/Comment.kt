package com.toyproject.simplesns.domain.post.entity

import com.toyproject.simplesns.domain.user.entity.User
import com.toyproject.simplesns.global.entity.BaseEntity
import javax.persistence.*

@Entity
class Comment(
    override val id: Long = 0L,

    val comment: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    val post: Post
) : BaseEntity(id)