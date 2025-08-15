package com.happypuppy.pet.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "post")
data class PostMongoDocument(
    @Id
    val id: String? = null,
    val title: String?,
    val content: String?,
)
