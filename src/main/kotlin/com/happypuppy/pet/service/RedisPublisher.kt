package com.happypuppy.pet.service

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class RedisPublisher(
    private val redisTemplate: StringRedisTemplate
) {
    fun publish(roomId: String, message: String) {
        val channel = "chatroom:$roomId"
        redisTemplate.convertAndSend(channel, message)
    }
}