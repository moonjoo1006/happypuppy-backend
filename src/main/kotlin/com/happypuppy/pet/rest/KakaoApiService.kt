package com.happypuppy.pet.rest

import com.happypuppy.pet.dto.response.ProfileResponse
import com.happypuppy.pet.exception.CommonException
import com.happypuppy.pet.exception.ResultCode
import com.happypuppy.pet.utils.bodyTo
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class KakaoApiService(
//    @Value("\${kakao.client-id}")
//    private val clientId: String? = null,
//    @Value("\${kakao.client-secret}")
//    private val clientSecret: String? = null,
//    @Value("\${kakao.redirect-uri}")
//    private val redirectUri: String? = null,
//    @Qualifier("restClientForKauth") val restClientForKauth: RestClient,
//    @Qualifier("restClientForKakaoAccountApi") val restClientForKApi: RestClient
) {
//    fun profile(accessToken: String): ProfileResponse {
//        return restClientForKauth.get()
//            .uri("/v1/user/me")
//            .header("Authorization", "Bearer $accessToken")
//            .exchange { request, response -> exchange(request, response) }
//            ?: throw CommonException.of(
//                ResultCode.BAD_REQUEST,
//                "Kakao API Error: Failed to get profile"
//            )
//    }

//    fun oauth(clientId: String, grantType: String, tokenName: String, token: String): KakaoAuthTokenResponse {
//        val body = LinkedMultiValueMap(
//            mapOf(
//                "grant_type" to listOf(grantType),
//                "client_id" to listOf(clientId),
//                tokenName to listOf(token),
//            ),
//        )
//        return restClient.post()
//            .uri("/oauth/token")
//            .body(body)
//            .exchange { request, response -> exchange(request, response) }
//            ?: throw PartnerException.of(PartnerErrorType.REST_CLIENT_EXCHANGE_ERROR)
//    }

    private inline fun <reified T : Any> exchange(
        request: HttpRequest,
        response: RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse,
    ): T? {
        when (response.statusCode) {
            HttpStatus.OK -> return response.bodyTo()

            else -> {
                val strApiResult = response.bodyTo(String::class.java)
                throw CommonException.of(
                    ResultCode.BAD_REQUEST,
                    "Kakao API Error: ${request.method} ${request.uri} ${response.statusCode} - $strApiResult"
                )
            }
        }
    }
}