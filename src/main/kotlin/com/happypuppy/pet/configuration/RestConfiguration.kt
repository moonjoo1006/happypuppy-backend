package com.happypuppy.pet.configuration

import org.springframework.boot.http.client.SimpleClientHttpRequestFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestClient

@Configuration
class RestConfiguration(
    val restClientBuilder: RestClient.Builder,
) {
    companion object {
        const val CONN_TIMEOUT_SECONDS = 5000
        const val READ_TIMEOUT_SECONDS = 5000
        const val WINSTON_READ_TIMEOUT_SECONDS = 10L
    }

    @Bean
    fun restClientForKakaoAccountApi(): RestClient {
        return RestClient.builder()
            .requestFactory(factory())
            .baseUrl("https://kapi.kakao.com")
            .build()
    }

    fun factory(): SimpleClientHttpRequestFactory {
        val factory = SimpleClientHttpRequestFactory()
        factory.setConnectTimeout(CONN_TIMEOUT_SECONDS)
        factory.setReadTimeout(READ_TIMEOUT_SECONDS)
        return factory
//    }
//
//    @Bean
//    fun restClientForKauth() = getRestClientBuilder()
//        .baseUrl("https://kauth.kakao.com")
//        .build()
//
//    @Bean
//    fun restClientForKApi() = getRestClientBuilder()
//        .baseUrl("https://kapi.kakao.com")
//        .build()
//
//    fun getRestClientBuilder(connectTimeout: Long? = null, readTimeout: Long? = null): RestClient.Builder {
//        val requestFactory = HttpComponentsClientHttpRequestFactory()
//            .apply {
//                setConnectTimeout((connectTimeout ?: CONN_TIMEOUT_SECONDS).toInt() * 1000)
//                setReadTimeout((readTimeout ?: READ_TIMEOUT_SECONDS).toInt() * 1000)
//            }
//
//        return restClientBuilder
//            .clone()
//            .requestFactory(requestFactory)
//            .requestInterceptor { request, body, execution ->
//                val response = execution.execute(request, body)
//                response
//            }
//    }
    }
}