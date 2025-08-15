package com.happypuppy.pet.database.service

import com.happypuppy.pet.common.ChatMemberStatus
import com.happypuppy.pet.database.entity.ChatMemberEntity
import com.happypuppy.pet.database.repository.ChatMemberRepository
import org.springframework.stereotype.Service

@Service
class ChatMemberService(
    val chatMemberRepository: ChatMemberRepository
) {
    fun getJoinedMembers(chatId: Long) = chatMemberRepository.findByChatIdAndStatusIn(
        chatId,
        listOf(ChatMemberStatus.JOINED)
    )

    fun getHistories(chatId: Long, userId: Long) =
        chatMemberRepository.findByChatIdAndUserIdOrderByCreatedAtDesc(chatId, userId)

    fun save(chatMember: ChatMemberEntity) = chatMemberRepository.save(chatMember)

    fun findByUserIdAndStatusIn(userId: Long, status: List<ChatMemberStatus>) =
        chatMemberRepository.findByUserIdAndStatusIn(userId, status)


}