package com.happypuppy.pet.controller

import com.happypuppy.pet.database.service.UserService
import com.happypuppy.pet.dto.request.CreateUserRequest
import com.happypuppy.pet.dto.request.UpdateUserRequest
import com.happypuppy.pet.dto.response.UserCheckResponse
import com.happypuppy.pet.dto.response.UserResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService
) {
    @Operation(
        tags = ["유저"],
        summary = "회원가입",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = UserResponse::class),
                    ),
                ],
            ),
        ],
    )
    @PostMapping("/users")
    fun createUser(@RequestBody request: CreateUserRequest): UserResponse {
        return userService.createUser(request)
    }

    @Operation(
        tags = ["유저"],
        summary = "회원정보 수정",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = UserResponse::class),
                    ),
                ],
            ),
        ],
    )
    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody request: UpdateUserRequest): UserResponse {
        return userService.updateUser(id, request)
    }

    @Operation(
        tags = ["유저"],
        summary = "유저조회",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = UserResponse::class),
                    ),
                ],
            ),
        ],
    )
    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long) = userService.findById(id)


    @Operation(
        tags = ["유저"],
        summary = "유저 확인(appUserId)",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = UserCheckResponse::class),
                    ),
                ],
            ),
        ],
    )
    @GetMapping("/users/check")
    fun checkUser(@RequestParam appUserId: Long): UserCheckResponse {
        return userService.checkByAppUserId(appUserId)
    }
}