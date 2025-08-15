package com.happypuppy.pet.dto.response

import com.happypuppy.pet.database.entity.ChatEntity

data class CreateChatResponse(
    val chatId: Long,
)

fun ChatEntity.toCreateChatResponse() = CreateChatResponse(
    chatId = this.id!!,
)