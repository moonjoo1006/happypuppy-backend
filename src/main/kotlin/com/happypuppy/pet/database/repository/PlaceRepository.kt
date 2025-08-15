package com.happypuppy.pet.database.repository

import com.happypuppy.pet.database.entity.PlaceEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : CrudRepository<PlaceEntity, Long> {
    @Query(
        value = """
        SELECT * FROM place
        WHERE ST_Distance_Sphere(
            location,
            ST_GeomFromText(:point, 4326)
        ) < :radius
        ORDER BY ST_Distance_Sphere(location, ST_GeomFromText(:point, 4326)) LIMIT :size
    """,
        nativeQuery = true
    )
    fun findNearby(@Param("point") point: String, @Param("radius") radius: Double, size: Int): List<PlaceEntity>
}
