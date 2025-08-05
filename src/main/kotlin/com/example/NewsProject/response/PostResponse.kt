package com.example.NewsProject.response

import com.example.NewsProject.entity.PostEntity
import com.example.NewsProject.utils.UUIDSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class PostResponse(
    @Serializable(with = UUIDSerializer::class)
    val uuid: UUID?,
    var title: String,
    var description: String,
    var content: String,
    var viewCount: Long,
    @Contextual var topics: MutableList<TopicResponse>,
    var publisher: PublisherResponse?
) {
    constructor(postEntity: PostEntity) : this(
        uuid = postEntity.id,
        title = postEntity.title ?: "",
        description = postEntity.description ?: "",
        content = postEntity.content ?: "",
        viewCount = postEntity.viewCount ?: 0,
        topics = postEntity.topic?.map { TopicResponse(it) }?.toMutableList() ?: mutableListOf(),
        publisher = postEntity.publisher?.let { PublisherResponse(it) }
    )
}