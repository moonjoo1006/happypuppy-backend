package com.happypuppy.pet.dto.response

import com.happypuppy.pet.common.ChatMemberStatus
import com.happypuppy.pet.database.entity.ChatMemberEntity
import java.time.LocalDateTime

data class ChatMemberResponse(
    val id: Long,
    val status: ChatMemberStatus,
    val chatId: Long,
    val userId: Long,
    val owner: Boolean,
    val createdAt: LocalDateTime,
)

fun ChatMemberEntity.toResponse() = ChatMemberResponse(
    id = this.id!!,
    status = this.status,
    chatId = this.chatId,
    userId = this.userId,
    owner = this.owner,
    createdAt = this.createdAt!!,
)
