package com.happypuppy.pet.database.service

import com.happypuppy.pet.database.entity.PlaceEntity
import com.happypuppy.pet.database.repository.PlaceRepository
import com.happypuppy.pet.dto.request.CreatePlaceRequest
import com.happypuppy.pet.dto.request.toCreateEntity
import com.happypuppy.pet.dto.response.PlaceResponse
import com.happypuppy.pet.dto.response.toResponse
import com.happypuppy.pet.exception.CommonException
import com.happypuppy.pet.exception.ResultCode
import org.springframework.stereotype.Service

@Service
class PlaceService(val placeRepository: PlaceRepository) {

    fun create(request: CreatePlaceRequest): PlaceResponse {
        val placeEntity = request.toCreateEntity()
        return placeRepository.save(placeEntity).toResponse()
    }

    fun findNearBy(latitude: String, longitude: String, radius: Double, size: Int = 10): List<PlaceResponse> {
        return placeRepository.findNearby("POINT($latitude $longitude)", radius, size)
            .map { it.toResponse() }
    }

    fun findById(placeId: Long): PlaceEntity {
        val optPlace = placeRepository.findById(placeId)
        if (optPlace.isEmpty) {
            throw CommonException.of(ResultCode.NOT_FOUND, "장소가 존재하지 않습니다.")
        }
        return optPlace.get()
    }
}