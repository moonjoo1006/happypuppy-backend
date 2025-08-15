package com.happypuppy.pet.controller

import com.happypuppy.pet.application.ChatApplication
import com.happypuppy.pet.dto.request.JoinChatRequest
import com.happypuppy.pet.dto.request.CreateChatRequest
import com.happypuppy.pet.dto.request.LeaveChatRequest
import com.happypuppy.pet.dto.response.ChatMemberResponse
import com.happypuppy.pet.dto.response.ChatResponse
import com.happypuppy.pet.dto.response.CreateChatResponse
import com.happypuppy.pet.dto.response.LeaveChatResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class ChatController(
    val chatApplication: ChatApplication,
) {
    @Operation(
        tags = ["채팅"],
        summary = "채팅방 목록",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        array = ArraySchema(schema = Schema(implementation = ChatResponse::class)),
                    ),
                ],
            ),
        ],
    )
    @GetMapping("/chat/my")
    fun my(@RequestParam userId: Long) = chatApplication.my(userId)

    @Operation(
        tags = ["채팅"],
        summary = "장소 채팅방 목록",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        array = ArraySchema(schema = Schema(implementation = ChatResponse::class)),
                    ),
                ],
            ),
        ],
    )
    @GetMapping("/chats")
    fun getChats(@RequestParam placeId: Long) = chatApplication.getChatsAtPlace(placeId)

    @Operation(
        tags = ["채팅"],
        summary = "채팅방 생성",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = CreateChatResponse::class),
                    ),
                ],
            ),
        ],
    )
    @PostMapping("/chat")
    fun createChat(@RequestBody request: CreateChatRequest) = chatApplication.createChat(request)

    @Operation(
        tags = ["채팅"],
        summary = "채팅방 참여자 목록 조회",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        array = ArraySchema(schema = Schema(implementation = ChatMemberResponse::class)),
                    ),
                ],
            ),
        ],
    )
    @GetMapping("/chat/{chatId}/members")
    fun getJoinedMembers(@PathVariable chatId: Long) = chatApplication.getJoinedMembers(chatId)

    @Operation(
        tags = ["채팅"],
        summary = "채팅방 참여",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = CreateChatResponse::class),
                    ),
                ],
            ),
        ],
    )
    @PostMapping("/chat/join")
    fun joinChat(@RequestBody request: JoinChatRequest) = chatApplication.joinChat(request)

    @Operation(
        tags = ["채팅"],
        summary = "채팅방 떠나기",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "성공",
                content = [
                    Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = Schema(implementation = LeaveChatResponse::class),
                    ),
                ],
            ),
        ],
    )
    @PostMapping("/chat/leave")
    fun leftChat(@RequestBody request: LeaveChatRequest) = chatApplication.leaveChat(request)
}