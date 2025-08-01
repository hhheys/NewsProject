package com.example.NewsProject.response

import com.example.NewsProject.entity.TopicEntity

data class TopicResponse(
    var id: Int?,
    var name: String?
) {
    constructor(topic: TopicEntity) : this(
        id = topic.id,
        name = topic.name
    )
}