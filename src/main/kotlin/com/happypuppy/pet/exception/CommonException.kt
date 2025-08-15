package com.happypuppy.pet.exception

open class CommonException(
    open val code: ResultCode = ResultCode.INTERNAL_SERVER_ERROR,
    override val message: String?,
) :
    RuntimeException(message ?: code.desc) {
    companion object {
        fun of(code: ResultCode, message: String? = null): CommonException {
            return CommonException(
                code = code,
                message = message ?: code.desc,
            )
        }
    }
}