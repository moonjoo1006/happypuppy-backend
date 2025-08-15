package com.happypuppy.pet.database.service

import com.happypuppy.pet.database.entity.UserEntity
import com.happypuppy.pet.database.repository.UserRepository
import com.happypuppy.pet.dto.request.CreateUserRequest
import com.happypuppy.pet.dto.request.UpdateUserRequest
import com.happypuppy.pet.dto.response.UserCheckResponse
import com.happypuppy.pet.dto.response.UserResponse
import com.happypuppy.pet.dto.response.toUserResponse
import com.happypuppy.pet.exception.CommonException
import com.happypuppy.pet.exception.ResultCode
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(val userRepository: UserRepository) {
    fun createUser(request: CreateUserRequest): UserResponse {
        val user = UserEntity(
            nickname = request.nickname,
            profileImageUrl = request.profileImageUrl,
            gender = request.gender,
            age = request.age,
            ageType = request.ageType,
            address = request.address,
            appUserId = request.appUserId,
            introduce = request.introduce,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),

        )
        return userRepository.save(user).toUserResponse()
    }

    fun updateUser(id: Long, request: UpdateUserRequest): UserResponse {
        val optUser = userRepository.findById(id)
        return if (optUser.isPresent) {
            val user = optUser.get()
            val copyUser = user.copy(
                nickname = request.nickname,
                profileImageUrl = request.profileImageUrl,
                age = request.age,
                ageType = request.ageType,
                address = request.address,
                introduce = request.introduce,
                updatedAt = LocalDateTime.now()
            )
            userRepository.save(copyUser).toUserResponse()
        } else {
            throw CommonException.of(ResultCode.BAD_REQUEST, "존재하지 않는 유저입니다. $id")
        }
    }

    fun findById(id: Long): UserResponse {
        val optUser = userRepository.findById(id)
        return if (optUser.isPresent) {
            optUser.get().toUserResponse()
        } else throw NoSuchElementException("User with id $id not found")
    }

    fun checkByAppUserId(appUserId: Long): UserCheckResponse {
        val users = userRepository.findByAppUserId(appUserId)
        return when {
            users.isEmpty() -> UserCheckResponse.isNotMember()
            users.size == 1 -> UserCheckResponse.isMember(users.first())
            else -> throw CommonException.of(ResultCode.INTERNAL_SERVER_ERROR, "중복된 유저입니다.")
        }
    }
}