package com.happypuppy.pet.database.entity

import com.happypuppy.pet.common.ChatStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Entity(name = "chat")
data class ChatEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val placeId: Long,

    @Enumerated(EnumType.STRING)
    val status: ChatStatus,

    val name: String,

    val owner: Long,

    val occupy: Int,

    val meetAt: LocalDateTime,

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,
)
