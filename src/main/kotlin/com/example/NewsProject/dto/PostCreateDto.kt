package com.example.NewsProject.dto

data class PostCreateDto (
    val title: String,
    val description: String,
    val content: String,
    val topicIDList: List<Int>
)