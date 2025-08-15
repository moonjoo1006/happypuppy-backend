package com.happypuppy.pet.database.repository

import com.happypuppy.pet.database.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByAppUserId(appUserId: Long): List<UserEntity>
}