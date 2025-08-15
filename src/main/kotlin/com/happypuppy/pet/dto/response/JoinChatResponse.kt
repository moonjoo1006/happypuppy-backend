package com.happypuppy.pet.dto.response

import com.happypuppy.pet.database.entity.ChatMemberEntity

data class JoinChatResponse(
    val chatId: Long,
    val userId: Long,
)

data class LeaveChatResponse(
    val chatId: Long,
    val userId: Long
)

fun ChatMemberEntity.toJoinChatResponse(): JoinChatResponse {
    return JoinChatResponse(
        chatId = this.chatId,
        userId = this.userId
    )
}

fun ChatMemberEntity.toLeftChatResponse(): LeaveChatResponse {
    return LeaveChatResponse(
        chatId = this.chatId,
        userId = this.userId
    )
}