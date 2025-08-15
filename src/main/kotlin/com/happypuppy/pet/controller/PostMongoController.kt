package com.happypuppy.pet.controller

import com.happypuppy.pet.mongo.PostMongoDocument
import com.happypuppy.pet.mongo.PostMongoService
import com.mongodb.client.MongoClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostMongoController(
    val mongoService: PostMongoService,
    private val mongo: MongoClient
) {
    @GetMapping("/{id}")
    fun get(@PathVariable id: String): PostMongoDocument? {
        return mongoService.findById(id)
    }

    @GetMapping("/search")
    fun search(@RequestParam title: String): List<PostMongoDocument> {
        return mongoService.findByTitle(title)
    }
}