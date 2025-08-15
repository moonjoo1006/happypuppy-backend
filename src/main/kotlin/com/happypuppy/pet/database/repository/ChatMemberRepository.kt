package com.happypuppy.pet.database.repository

import com.happypuppy.pet.common.ChatMemberStatus
import com.happypuppy.pet.database.entity.ChatMemberEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatMemberRepository : CrudRepository<ChatMemberEntity, Long> {
    fun findByChatIdAndStatusIn(chatId: Long, status: List<ChatMemberStatus>): List<ChatMemberEntity>
    fun findByChatId(chatId: Long): List<ChatMemberEntity>
    fun findByUserIdAndStatusIn(userId: Long, status: List<ChatMemberStatus>): List<ChatMemberEntity>
    fun findByChatIdAndUserIdOrderByCreatedAtDesc(chatId: Long, userId: Long): List<ChatMemberEntity>
}