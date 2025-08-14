package com.example.NewsProject.response

import com.example.NewsProject.entity.PostEntity
import com.example.NewsProject.utils.UUIDSerializer
import io.swagger.v3.oas.annotations.media.Schema
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class PostResponse(
    @Serializable(with = UUIDSerializer::class)
    @Schema(description = "UUID поста")
    val uuid: UUID?,
    @Schema(description = "Заголовок поста")
    var title: String,
    @Schema(description = "Описание поста")
    var description: String,
    @Schema(description = "Основное содержимое поста")
    var content: String,
    @Schema(description = "Количество просмотров поста")
    var viewCount: Long,
    @Schema(description = "Список топиков поста")
    @Contextual var topics: MutableList<TopicResponse>,
    @Schema(description = "Аккаунт издателя поста")
    var publisher: PublisherResponse?,
    @Schema(description = "Количество лайков")
    var likeCount: Long,
    @Schema(description = "Количество дизлайков")
    val dislikeCount: Long
) {
    constructor(postEntity: PostEntity) : this(
        uuid = postEntity.id,
        title = postEntity.title ?: "",
        description = postEntity.description ?: "",
        content = postEntity.content ?: "",
        viewCount = postEntity.viewCount ?: 0,
        topics = postEntity.topic?.map { TopicResponse(it) }?.toMutableList() ?: mutableListOf(),
        publisher = postEntity.publisher?.let { PublisherResponse(it) },
        likeCount = postEntity.likeCount,
        dislikeCount = postEntity.dislikeCount
    )
}