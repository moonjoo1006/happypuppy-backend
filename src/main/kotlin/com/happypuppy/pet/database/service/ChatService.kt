package com.happypuppy.pet.database.service

import com.happypuppy.pet.database.entity.ChatEntity
import com.happypuppy.pet.database.entity.ChatMemberEntity
import com.happypuppy.pet.database.repository.ChatMemberRepository
import com.happypuppy.pet.database.repository.ChatRepository
import com.happypuppy.pet.exception.CommonException
import com.happypuppy.pet.exception.ResultCode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ChatService(
    val chatRepository: ChatRepository,
    val chatMemberRepository: ChatMemberRepository
) {
    fun findByIdIn(ids: List<Long>): List<ChatEntity> {
        return chatRepository.findAllById(ids).toList()
    }

    fun getChatsAtPlace(placeId: Long, meetAt: LocalDateTime): List<ChatEntity> {
        return chatRepository.findByPlaceIdAndMeetAtAfter(placeId, meetAt)
    }

    @Transactional
    fun create(chat: ChatEntity, chatMember: ChatMemberEntity): ChatEntity {
        val chat = chatRepository.save(chat)
        chatMember.chatId = chat.id!!
        chatMemberRepository.save(chatMember)
        return chat
    }

    fun getOrThrow(id: Long): ChatEntity {
        return chatRepository.findByIdOrNull(id) ?: throw CommonException.of(ResultCode.NOT_FOUND)
    }
}