package com.happypuppy.pet.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class KakaoTokenResponse(
    @JsonProperty("access_token")
    val accessToken: String? = null,

    @JsonProperty("access_token")
    val tokenType: String? = null,

    @JsonProperty("refresh_token")
    val refreshToken: String? = null,

    @JsonProperty("expires_in")
    private val expiresIn: Int? = null,

    @JsonProperty("scope")
    private val scope: String? = null,

    @JsonProperty("refresh_token_expires_in")
    private val refreshTokenExpiresIn: Int? = null,
)
