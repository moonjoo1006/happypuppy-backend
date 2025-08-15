package com.happypuppy.pet.database.repository

import com.happypuppy.pet.database.entity.ChatEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ChatRepository : CrudRepository<ChatEntity, Long> {
    fun findByIdIn(ids: List<Long>): List<ChatEntity>
    fun findByPlaceIdAndMeetAtAfter(placeId: Long, meetAt: LocalDateTime): List<ChatEntity>
}