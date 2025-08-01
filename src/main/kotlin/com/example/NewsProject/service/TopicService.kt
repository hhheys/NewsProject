package com.example.NewsProject.service

import com.example.NewsProject.dto.TopicDto
import com.example.NewsProject.responce.TopicResponce

interface TopicService {
    fun getTopicById(id: Int): TopicResponce
    fun getAllTopics(): List<TopicResponce>
    fun createTopic(topic: TopicDto)
    fun deleteTopicById(id: Int)
    fun updateTopicById(id: Int, updatedTopic: TopicDto)
}