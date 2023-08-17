package com.toyproject.simplesns.global.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.sql.Date
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.ZonedDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open val id: Long = 0L,

    @CreatedDate
    var createdAt: ZonedDateTime? = null,

    @LastModifiedDate
    var modifiedAt: ZonedDateTime? = null
)