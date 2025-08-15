package com.happypuppy.pet.service

import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

@Component
class RedisSubscriber(
    private val messagingTemplate: SimpMessagingTemplate
) : MessageListener {
    override fun onMessage(message: Message, pattern: ByteArray?) {
        val topic = String(message.channel)
        val payload = String(message.body)
        val roomId = topic.substringAfter("chatroom:")
        messagingTemplate.convertAndSend("/topic/chat/$roomId", payload)
    }
}
