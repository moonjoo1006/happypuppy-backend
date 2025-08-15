package com.happypuppy.pet.database.entity

import com.happypuppy.pet.common.AddressType
import com.happypuppy.pet.common.AgeType
import com.happypuppy.pet.common.GenderType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "user")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var nickname: String? = null,

    var profileImageUrl: String? = null,

    @Enumerated(EnumType.STRING)
    val gender: GenderType? = null,

    var age: Int? = null,

    @Enumerated(EnumType.STRING)
    val ageType: AgeType? = null,

    val appUserId: Long? = null,

    var introduce: String? = null,

    @Enumerated(EnumType.STRING)
    var address: AddressType? = null,

    val phoneNumber: String? = null,

    val showPhoneNumber: Boolean? = null,

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,
)