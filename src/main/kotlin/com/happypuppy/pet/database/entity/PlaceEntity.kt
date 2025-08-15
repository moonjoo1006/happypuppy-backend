package com.happypuppy.pet.database.entity

import com.happypuppy.pet.common.PlaceType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.locationtech.jts.geom.Point
import java.time.LocalDateTime

@Entity(name = "place")
data class PlaceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String? = null,

    @Enumerated(EnumType.STRING)
    val placeType: PlaceType? = null,

    val address: String? = null,

    val roadAddress: String? = null,

    val latitude: Double? = null,

    val longitude: Double? = null,

    @Column(columnDefinition = "POINT")
    val location: Point,

    val contact: String? = null,

    val homepage: String? = null,

    val offDays: String? = null,

    val operationTime: String? = null,

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,
)