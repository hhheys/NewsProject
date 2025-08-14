package com.example.NewsProject.consts

import kotlinx.serialization.Serializable

@Serializable
enum class EventType{
    VIEW, LIKE, DISLIKE, COMMENT
}