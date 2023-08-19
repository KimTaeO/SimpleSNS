package com.toyproject.simplesns.domain.post.entity

import javax.persistence.*

@Entity
class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val content: String,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "img", joinColumns = [JoinColumn(name = "id")])
    val imgUrls: List<String>
)