package com.happypuppy.pet.controller

import com.happypuppy.pet.database.service.PlaceService
import com.happypuppy.pet.dto.request.CreatePlaceRequest
import com.happypuppy.pet.dto.response.PlaceResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PlaceController(
    val placeService: PlaceService
) {
    @Operation(
        tags = ["장소"],
        summary = "장소생성",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = PlaceResponse::class),
                    ),
                ],
            ),
        ],
    )
    @PostMapping("/places")
    fun createPlace(@RequestBody request: CreatePlaceRequest): PlaceResponse {
        return placeService.create(request)
    }

    @Operation(
        tags = ["장소"],
        summary = "장소정보",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        array = ArraySchema(schema = Schema(implementation = PlaceResponse::class)),
                    ),
                ],
            ),
        ],
    )
    @GetMapping("/places/nearby")
    fun getNearbyStores(
        @RequestParam latitude: String,
        @RequestParam longitude: String,
        @RequestParam radius: Double,
        @RequestParam size: Int = 10
    ) = placeService.findNearBy(latitude, longitude, radius, size)
}