package com.happypuppy.pet.database.entity

import com.happypuppy.pet.common.ChatMemberStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "chat_member")
data class ChatMemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    var status: ChatMemberStatus,

    var chatId: Long,

    val userId: Long,

    val owner: Boolean,

    var createdAt: LocalDateTime? = null,
)
