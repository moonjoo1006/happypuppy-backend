package com.happypuppy.pet.dto.response

data class ProfileResponse(
    val id: Long,
    val properties: ProfileProperties,
)

data class ProfileProperties(
    val nickname: String?,
    val profileImage: String?,
    val thumbnailImage: String?,
    val email: String?,
)