package com.happypuppy.pet.dto.response

import com.happypuppy.pet.common.PlaceType
import com.happypuppy.pet.database.entity.PlaceEntity

data class PlaceResponse(
    val id: Long?,
    val name: String?,
    val placeType: PlaceType?,
    val address: String?,
    val roadAddress: String?,
    val latitude: String?,
    val longitude: String?,
    val contact: String?,
    val homepage: String?,
    val offDays: String?,
    val operationTime: String?,
)

fun PlaceEntity.toResponse() = PlaceResponse(
    id = this.id,
    name = this.name,
    placeType = this.placeType,
    address = this.address,
    roadAddress = this.roadAddress,
    latitude = this.latitude?.toString(),
    longitude = this.longitude?.toString(),
    contact = this.contact,
    homepage = this.homepage,
    offDays = this.offDays,
    operationTime = this.operationTime
)