package com.happypuppy.pet.dto.request

data class ChatMessageRequest(
    val sender: String,
    val content: String
)