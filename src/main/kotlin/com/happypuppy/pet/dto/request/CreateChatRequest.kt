package com.happypuppy.pet.dto.request

import com.happypuppy.pet.common.ChatMemberStatus
import com.happypuppy.pet.common.ChatStatus
import com.happypuppy.pet.database.entity.ChatEntity
import com.happypuppy.pet.database.entity.ChatMemberEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class CreateChatRequest(
    val userId: Long,
    val name: String,
    val placeId: Long,
    val occupy: Int,
    val meetDate: LocalDate,
    val meetTime: LocalTime,
    //todo 소개, 짧은소개, 이미지
)

fun CreateChatRequest.toChatEntity() = ChatEntity(
    status = ChatStatus.ON,
    placeId = this.placeId,
    name = this.name,
    occupy = this.occupy,
    meetAt = LocalDateTime.of(this.meetDate, this.meetTime),
    owner = this.userId
)

fun CreateChatRequest.toOwnerChatMemberEntity() = ChatMemberEntity(
    status = ChatMemberStatus.JOINED,
    chatId = 0,
    userId = this.userId,
    owner = true
)