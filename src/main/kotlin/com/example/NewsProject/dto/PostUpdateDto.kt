package com.example.NewsProject.dto

import java.util.UUID

data class PostUpdateDto (
    val title: String? = null,
    val description: String? = null,
    val content: String? = null,
    val topicIDList: List<Int>? = null,
    val publisherUUID: UUID? = null
)