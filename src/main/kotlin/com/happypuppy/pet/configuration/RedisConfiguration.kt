//package com.happypuppy.pet.configuration
//
//import com.happypuppy.pet.service.RedisSubscriber
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.redis.connection.RedisConnectionFactory
//import org.springframework.data.redis.core.StringRedisTemplate
//import org.springframework.data.redis.listener.PatternTopic
//import org.springframework.data.redis.listener.RedisMessageListenerContainer
//
//@Configuration
//class RedisConfiguration {
//    @Bean
//    fun redisContainer(
//        connectionFactory: RedisConnectionFactory,
//        subscriber: RedisSubscriber
//    ): RedisMessageListenerContainer {
//        return RedisMessageListenerContainer().apply {
//            setConnectionFactory(connectionFactory)
//            addMessageListener(subscriber, PatternTopic("chatroom:*"))
//        }
//    }
//
//    @Bean
//    fun stringRedisTemplate(connectionFactory: RedisConnectionFactory): StringRedisTemplate {
//        return StringRedisTemplate(connectionFactory)
//    }
//}