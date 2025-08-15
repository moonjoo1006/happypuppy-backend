package com.happypuppy.pet.mongo

import org.springframework.stereotype.Service

@Service
class PostMongoService(
    val postMongoRepository: PostMongoRepository,
) {
    fun findById(id: String): PostMongoDocument? {
        return postMongoRepository.findById(id).orElse(null)
    }

    fun findByTitle(title: String): List<PostMongoDocument> {
        return postMongoRepository.findByTitle(title)
    }
}