package com.happypuppy.pet.exception

import org.springframework.http.HttpStatus

enum class ResultCode(
    val _code: String, val desc: String, val httpStatus: HttpStatus
) {
    OK("00200", "성공", HttpStatus.OK),
    BAD_REQUEST("00400", "잘못된 요청", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("00401", "인증 실패", HttpStatus.UNAUTHORIZED),
    NOT_FOUND("00403", "없는 요청", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("99999", "내부 서버 에러", HttpStatus.INTERNAL_SERVER_ERROR),

    NOT_EXIST_CHAT("20001", "존재하지 않는 챗입니다.", HttpStatus.BAD_REQUEST),
    ALREADY_JOIN_CHAT("20002", "이미 참가한 챗입니다.", HttpStatus.BAD_REQUEST),
    KICKED_CHAT("20003", "추방당한 챗입니다..", HttpStatus.BAD_REQUEST),
}