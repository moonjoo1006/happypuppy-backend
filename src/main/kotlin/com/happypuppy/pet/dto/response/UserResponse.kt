package com.happypuppy.pet.dto.response

import com.happypuppy.pet.common.AddressType
import com.happypuppy.pet.common.AgeType
import com.happypuppy.pet.common.GenderType
import com.happypuppy.pet.database.entity.UserEntity

data class UserResponse(
    val id: Long?,
    val nickname: String?,
    val profileImageUrl: String?,
    val gender: GenderType?,
    val ageType: AgeType?,
    val appUserId: Long?,
    val introduce: String?,
    val address: AddressType?,
    val phoneNumber: String?,
    val showPhoneNumber: Boolean?,

    )


fun UserEntity.toUserResponse() = UserResponse(
    id = this.id,
    nickname = this.nickname,
    profileImageUrl = this.profileImageUrl,
    gender = this.gender,
    ageType = this.ageType,
    appUserId = this.appUserId,
    introduce = this.introduce,
    address = this.address,
    phoneNumber = this.phoneNumber,
    showPhoneNumber = this.showPhoneNumber,
)