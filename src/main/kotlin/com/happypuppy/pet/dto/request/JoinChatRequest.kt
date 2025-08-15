package com.happypuppy.pet.dto.request

import com.happypuppy.pet.common.ChatMemberStatus
import com.happypuppy.pet.database.entity.ChatMemberEntity
import java.time.LocalDateTime

data class JoinChatRequest(
    val chatId: Long,
    val userId: Long,
)

data class LeaveChatRequest(
    val chatId: Long,
    val userId: Long,
)

data class KickChatRequest(
    val chatId: Long,
    val useRId: Long,
    val kickedUserId: Long,
)


fun JoinChatRequest.toChatMemberEntity(): ChatMemberEntity {
    return ChatMemberEntity(
        status = ChatMemberStatus.JOINED,
        chatId = this.chatId,
        userId = this.userId,
        owner = false,
        createdAt = LocalDateTime.now()
    )
}