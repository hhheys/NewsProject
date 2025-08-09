package com.example.NewsProject.service

import com.example.NewsProject.dto.TopicDto
import com.example.NewsProject.entity.TopicEntity
import com.example.NewsProject.response.TopicResponse

interface TopicService {
    fun getAllTopics(): List<TopicResponse>
    fun createTopic(topic: TopicDto): TopicResponse
    fun deleteTopicById(id: Int)
    fun updateTopicById(id: Int, updatedTopic: TopicDto)
    fun findByIds(idList: List<Int>): List<TopicEntity>
    fun findById(id: Int): TopicEntity
}