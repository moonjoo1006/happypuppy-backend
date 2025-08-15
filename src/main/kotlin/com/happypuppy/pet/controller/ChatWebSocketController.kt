package com.happypuppy.pet.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.happypuppy.pet.dto.request.ChatMessageRequest
import com.happypuppy.pet.service.RedisPublisher
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class ChatWebSocketController(
    private val redisPublisher: RedisPublisher,
    private val objectMapper: ObjectMapper
) {
    @MessageMapping("/chat/{roomId}")
    fun handleMessage(@DestinationVariable roomId: String, message: ChatMessageRequest) {
        val json = objectMapper.writeValueAsString(message)
        redisPublisher.publish(roomId, json)
    }
}
