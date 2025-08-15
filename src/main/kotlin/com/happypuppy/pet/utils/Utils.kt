package com.happypuppy.pet.utils

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point
import org.springframework.web.client.RestClient


fun toPoint(latitude: Double, longitude: Double): Point {
    val geometryFactory = GeometryFactory()
    val point = geometryFactory.createPoint(Coordinate(longitude, latitude)) // 순서: 경도, 위도
    point.srid = 4326 // SRID 4326 설정
    return point
}

inline fun <reified T> RestClient.RequestHeadersSpec.ConvertibleClientHttpResponse.bodyTo(): T = bodyTo(T::class.java)!!