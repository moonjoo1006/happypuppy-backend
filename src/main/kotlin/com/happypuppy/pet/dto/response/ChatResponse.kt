package com.happypuppy.pet.dto.response

import com.happypuppy.pet.common.ChatStatus
import com.happypuppy.pet.database.entity.ChatEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class ChatResponse(
    val id: Long,
    val status: ChatStatus,
    val name: String,
    val meetDate: LocalDate,
    val meetTime: LocalTime,
    val meetAt: LocalDateTime,
    val imageUrl: String?,
    val introduce: String?,
    val tags: List<String>?
)

fun ChatEntity.toResponse() = ChatResponse(
    id = this.id!!,
    status = this.status,
    name = this.name,
    meetDate = this.meetAt.toLocalDate(),
    meetTime = this.meetAt.toLocalTime(),
    meetAt = this.meetAt,
    imageUrl = this.imageUrl,
    introduce = this.introduce,
    tags = this.tags?.split(",")
)