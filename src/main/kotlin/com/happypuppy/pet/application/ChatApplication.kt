package com.happypuppy.pet.application

import com.happypuppy.pet.common.ChatMemberStatus
import com.happypuppy.pet.database.service.ChatMemberService
import com.happypuppy.pet.database.service.ChatService
import com.happypuppy.pet.database.service.PlaceService
import com.happypuppy.pet.dto.request.JoinChatRequest
import com.happypuppy.pet.dto.request.CreateChatRequest
import com.happypuppy.pet.dto.request.LeaveChatRequest
import com.happypuppy.pet.dto.request.toChatEntity
import com.happypuppy.pet.dto.request.toChatMemberEntity
import com.happypuppy.pet.dto.request.toOwnerChatMemberEntity
import com.happypuppy.pet.dto.response.ChatMemberResponse
import com.happypuppy.pet.dto.response.ChatResponse
import com.happypuppy.pet.dto.response.CreateChatResponse
import com.happypuppy.pet.dto.response.JoinChatResponse
import com.happypuppy.pet.dto.response.LeaveChatResponse
import com.happypuppy.pet.dto.response.toCreateChatResponse
import com.happypuppy.pet.dto.response.toJoinChatResponse
import com.happypuppy.pet.dto.response.toLeftChatResponse
import com.happypuppy.pet.dto.response.toResponse
import com.happypuppy.pet.exception.CommonException
import com.happypuppy.pet.exception.ResultCode
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ChatApplication(
    val chatService: ChatService,
    val chatMemberService: ChatMemberService,
    val placeService: PlaceService,
) {
    fun my(userId: Long): List<ChatResponse> {
        val chatMembers = chatMemberService.findByUserIdAndStatusIn(userId, listOf(ChatMemberStatus.JOINED))
        val chatIds = chatMembers.map { it.chatId }
        val chats = chatService.findByIdIn(chatIds)

        val firstDayOfMonth = LocalDateTime.now().withDayOfMonth(1)
            .withHour(0).withMinute(0).withSecond(0).withNano(0)
        return chats.filter { it.meetAt.isAfter(firstDayOfMonth) }
            .map { it.toResponse() }
    }

    fun getChatsAtPlace(placeId: Long): List<ChatResponse> {
        val place = placeService.findById(placeId)
        val chats = chatService.getChatsAtPlace(placeId, LocalDateTime.now())
        return chats.map { it.toResponse() }
            .sortedBy { it.meetAt }
    }

    fun createChat(request: CreateChatRequest): CreateChatResponse {
        val chat = request.toChatEntity()
        val chatMember = request.toOwnerChatMemberEntity()
        return chatService.create(chat, chatMember).toCreateChatResponse()
    }

    fun getJoinedMembers(chatId: Long): List<ChatMemberResponse> {
        return chatMemberService.getJoinedMembers(chatId)
            .map { it.toResponse() }
    }

    fun joinChat(request: JoinChatRequest): JoinChatResponse {
        val chatId = request.chatId
        val userId = request.userId

        validateJoin(chatId, userId)
        val chatMemberEntity = request.toChatMemberEntity()
        return chatMemberService.save(chatMemberEntity)
            .toJoinChatResponse()
    }


    fun leaveChat(request: LeaveChatRequest): LeaveChatResponse {
        val chatId = request.chatId
        val userId = request.userId

        validateLeft(chatId, userId)

        val chatMemberEntity = chatMemberService.getHistories(chatId, userId).first()
        chatMemberEntity.status = ChatMemberStatus.LEFT
        chatMemberEntity.createdAt = LocalDateTime.now()
        return chatMemberService.save(chatMemberEntity)
            .toLeftChatResponse()
    }


    private fun validateJoin(chatId: Long, userId: Long) {
        chatService.getOrThrow(chatId)

        val histories = chatMemberService.getHistories(chatId, userId)
        when {
            histories.isEmpty() -> return
            histories.any { it.status == ChatMemberStatus.KICKED } ->
                throw CommonException.of(ResultCode.NOT_FOUND, "추방당한 모임입니다..")

            histories.first().status == ChatMemberStatus.JOINED ->
                throw CommonException.of(ResultCode.NOT_FOUND, "이미 참여한 모임입니다.")
        }
    }

    private fun validateLeft(chatId: Long, userId: Long) {
        chatService.getOrThrow(chatId)
        val histories = chatMemberService.getHistories(chatId, userId)
        when {
            histories.isEmpty() || histories.first().status == ChatMemberStatus.JOINED -> return
            else ->
                throw CommonException.of(ResultCode.NOT_FOUND, "이미 나간 모임입니다.")
        }
    }
}