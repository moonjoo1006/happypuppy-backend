package com.happypuppy.pet.mongo

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Service

@Service
interface PostMongoRepository : MongoRepository<PostMongoDocument, String> {
    fun findByTitle(title: String): List<PostMongoDocument>
}

