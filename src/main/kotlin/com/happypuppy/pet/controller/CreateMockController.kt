package com.happypuppy.pet.controller

import com.happypuppy.pet.common.AddressType
import com.happypuppy.pet.common.AgeType
import com.happypuppy.pet.common.ChatStatus
import com.happypuppy.pet.common.GenderType
import com.happypuppy.pet.database.entity.ChatEntity
import com.happypuppy.pet.database.entity.UserEntity
import com.happypuppy.pet.database.repository.ChatRepository
import com.happypuppy.pet.database.repository.UserRepository
import com.happypuppy.pet.database.service.PlaceService
import com.happypuppy.pet.dto.request.CreatePlaceRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class CreateMockController(
    val chatRepository: ChatRepository,
    val placeService: PlaceService,
    val userRepository: UserRepository,
) {

    @GetMapping("/mock/places")
    fun createMockPlaces(): String {
        val places = listOf(
            CreatePlaceRequest(
                name = "분당중앙공원 애완견 놀이터",
                placeType = "PARK",
                address = "경기도 성남시 분당구 수내동 65",
                roadAddress = "경기도 성남시 분당구 경기도 성남시 분당구 성남대로 550",
                latitude = "37.377266",
                longitude = "127.123758",
                contact = "0317294907",
                homepage = "http://www.seongnam.go.kr/parks/park/parkView.do?parkId=100",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
            CreatePlaceRequest(
                name = "율동공원",
                placeType = "PARK",
                address = "경기도 성남시 분당구 율동 399",
                roadAddress = "경기도 성남시 분당구 율동 399",
                latitude = "37.377686",
                longitude = "127.151387",
                contact = "0317028713",
                homepage = "http://www.ydpark.co.kr",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
            CreatePlaceRequest(
                name = "21세기 세계로약국",
                placeType = "PHARMACY",
                address = "경기도,성남시 중원구,금광동",
                roadAddress = "경기도 성남시 중원구 금광동 11",
                latitude = "37.44475147",
                longitude = "127.158591",
                contact = "0317028713",
                homepage = "http://www.ydpark.co.kr",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
            CreatePlaceRequest(
                name = "24시 폴 동물병원",
                placeType = "HOSPITAL",
                address = "경기도 성남시 분당구 정자동 15-2",
                roadAddress = "경기도 성남시 분당구 성남대로 385",
                latitude = "37.37056133",
                longitude = "127.107512",
                contact = "0317028713",
                homepage = "http://www.ydpark.co.kr",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
            CreatePlaceRequest(
                name = "24시분당리더스동물의료원",
                placeType = "HOSPITAL",
                address = "경기도 성남시 분당구 구미동 157",
                roadAddress = "경기도 성남시 분당구 성남대로 45",
                latitude = "37.34005352",
                longitude = "127.108398",
                contact = "0317028713",
                homepage = "http://www.ydpark.co.kr",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
            CreatePlaceRequest(
                name = "365그린약국",
                placeType = "HOSPITAL",
                address = "경기도 성남시 분당구 금곡동 161",
                roadAddress = "경기도 성남시 분당구 성남대로 165",
                latitude = "37.35076234",
                longitude = "127.108309",
                contact = "0317028713",
                homepage = "http://www.ydpark.co.kr",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
            CreatePlaceRequest(
                name = "강아지고양이편의점 분당정자점",
                placeType = "SUPPLIES",
                address = "경기도 성남시 분당구 정자동 82-2",
                roadAddress = "경기도 성남시 분당구 느티로51번길 17",
                latitude = "37.37019684",
                longitude = "127.110085",
                contact = "0317028713",
                homepage = "http://www.ydpark.co.kr",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
            CreatePlaceRequest(
                name = "그루밍단",
                placeType = "BEAUTY",
                address = "경기도 성남시 분당구 정자동 165-1",
                roadAddress = "경기도 성남시 분당구 정자일로 146",
                latitude = "37.36300918",
                longitude = "127.106533",
                contact = "0317028713",
                homepage = "http://www.ydpark.co.kr",
                offDays = "연중무휴",
                operationTime = "연중무휴",
            ),
        )

        places.forEach { placeService.create(it) }

        return "success";
    }

    @GetMapping("/mock/chats")
    fun createMockChats(): String {
        val chats = listOf(
            ChatEntity(
                placeId = 1L,
                status = ChatStatus.ON,
                name = "테스트 채팅방1",
                owner = 1,
                meetAt = LocalDateTime.now().plusDays(3),
            ),
            ChatEntity(
                placeId = 1L,
                status = ChatStatus.ON,
                name = "테스트 채팅방2",
                owner = 1,
                meetAt = LocalDateTime.now().plusDays(7),
            ),
            ChatEntity(
                placeId = 1L,
                status = ChatStatus.ON,
                name = "테스트 채팅방3",
                owner = 1,
                meetAt = LocalDateTime.now().plusDays(5),
            ),
            ChatEntity(
                placeId = 1L,
                status = ChatStatus.ON,
                name = "테스트 채팅방4",
                owner = 1,
                meetAt = LocalDateTime.now().minusWeeks(1),
            ),
            ChatEntity(
                placeId = 1L,
                status = ChatStatus.ON,
                name = "테스트 채팅방5",
                owner = 1,
                meetAt = LocalDateTime.now().plusDays(10),
            ),
            ChatEntity(
                placeId = 1L,
                status = ChatStatus.ON,
                name = "테스트 채팅방6",
                owner = 1,
                meetAt = LocalDateTime.now().minusWeeks(2),
            )
        )
        chatRepository.saveAll(chats)
        return "success";
    }

    @GetMapping("/mock/users")
    fun createMockUsers(): String {
        val users = listOf(
            UserEntity(
                id = null,
                nickname = "theo",
                profileImageUrl = null,
                gender = GenderType.MALE,
                age = 30,
                ageType = AgeType.THIRTIES,
                appUserId = 1,
                introduce = "안녕하세요 테오입니다.",
                address = AddressType.GYEONGGI,
                phoneNumber = "01090608302",
                showPhoneNumber = true
            )
        )
        userRepository.saveAll(users)
        return "success"
    }
}