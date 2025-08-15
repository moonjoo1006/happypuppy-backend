package com.happypuppy.pet.application

import com.happypuppy.pet.database.service.ChatService
import com.happypuppy.pet.database.service.PlaceService
import org.springframework.stereotype.Service

@Service
class PlaceApplication(
    val placeService: PlaceService,
    val chatService: ChatService
) {
    fun getPlaceChats(placeId: Long) {

    }
}