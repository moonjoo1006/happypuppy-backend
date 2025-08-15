package com.happypuppy.pet.dto.request

import com.happypuppy.pet.common.AddressType
import com.happypuppy.pet.common.AgeType
import com.happypuppy.pet.common.GenderType

data class CreateUserRequest(
    val nickname: String,
    val profileImageUrl: String?,
    val gender: GenderType,
    val age: Int?,  //연령대
    val ageType: AgeType?,
    val address: AddressType,    //enum type로 정의, 쿠폰에 있는 지역
    val introduce: String,  //
    val phoneNumber: String,
    val showPhoneNumber: Boolean,
    val appUserId: Long,
)

data class UpdateUserRequest(
    val nickname: String,
    val profileImageUrl: String?,
    val age: Int?,  //연령대
    val ageType: AgeType?,
    val address: AddressType,    //enum type로 정의, 쿠폰에 있는 지역
    val introduce: String,  //
)