package com.example.NewsProject.responce

import com.example.NewsProject.entity.TopicEntity

data class TopicResponce(
    var name: String?
) {
    constructor(topic: TopicEntity) : this(
        name = topic.name
    )
}
