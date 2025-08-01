package com.example.NewsProject.service

import com.example.NewsProject.dto.TopicDto
import com.example.NewsProject.response.TopicResponse

interface TopicService {
    fun getTopicById(id: Int): TopicResponse
    fun getAllTopics(): List<TopicResponse>
    fun createTopic(topic: TopicDto)
    fun deleteTopicById(id: Int)
    fun updateTopicById(id: Int, updatedTopic: TopicDto)
}