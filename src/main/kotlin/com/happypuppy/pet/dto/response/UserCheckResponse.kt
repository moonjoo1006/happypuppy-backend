package com.happypuppy.pet.dto.response

import com.happypuppy.pet.database.entity.UserEntity

data class UserCheckResponse(
    val userId: Long? = null,
    val isMember: Boolean,
) {
    companion object {
        fun isMember(user: UserEntity) = UserCheckResponse(userId = user.id, isMember = true)
        fun isNotMember() = UserCheckResponse(isMember = false)
    }
}
