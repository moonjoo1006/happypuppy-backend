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
    val meetDate: LocalDate,
    val meetTime: LocalTime,
    val imageUrl: String?,
    val introduce: String?,
    val tags: List<String>?,
    //todo 소개, 짧은소개, 이미지
)

fun CreateChatRequest.toChatEntity() = ChatEntity(
    status = ChatStatus.ON,
    placeId = this.placeId,
    name = this.name,
    meetAt = LocalDateTime.of(this.meetDate, this.meetTime),
    owner = this.userId,
    imageUrl = this.imageUrl,
    introduce = this.introduce,
    tags = this.tags?.joinToString(separator = ","),
)

fun CreateChatRequest.toOwnerChatMemberEntity() = ChatMemberEntity(
    status = ChatMemberStatus.JOINED,
    chatId = 0,
    userId = this.userId,
    owner = true
)