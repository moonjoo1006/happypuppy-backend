package com.happypuppy.pet.dto.request

import com.happypuppy.pet.common.PlaceType
import com.happypuppy.pet.database.entity.PlaceEntity
import com.happypuppy.pet.utils.toPoint
import java.time.LocalDateTime

data class CreatePlaceRequest(
    val name: String?,
    val placeType: String?,
    val address: String?,
    val roadAddress: String?,
    val latitude: String,
    val longitude: String,
    val contact: String?,
    val homepage: String?,
    val offDays: String?,
    val operationTime: String?,
)

fun CreatePlaceRequest.toCreateEntity() = PlaceEntity(
    name = this.name,
    placeType = this.placeType?.let { PlaceType.valueOf(it) },
    address = this.address,
    roadAddress = this.roadAddress,
    latitude = this.latitude.toDouble(),
    longitude = this.longitude.toDouble(),
    contact = this.contact,
    homepage = this.homepage,
    offDays = this.offDays,
    operationTime = this.operationTime,
    location = toPoint(
        this.latitude.toDouble(),
        this.longitude.toDouble()),
    createdAt = LocalDateTime.now(), // Assuming these fields are set by the database
    updatedAt = LocalDateTime.now(),
)

