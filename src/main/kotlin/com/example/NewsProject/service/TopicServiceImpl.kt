package com.example.NewsProject.service

import com.example.NewsProject.dao.TopicRepository
import com.example.NewsProject.dto.TopicDto
import com.example.NewsProject.entity.TopicEntity
import com.example.NewsProject.handlers.exceptions.BadRequestException
import com.example.NewsProject.response.TopicResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private val topicRepository: TopicRepository
) : TopicService {
    @Transactional
    override fun getAllTopics(): List<TopicResponse> {
        return topicRepository.findAll().map { TopicResponse(it) }
    }

    @Transactional
    override fun createTopic(topic: TopicDto): TopicResponse {
        val topicEntity = TopicEntity().apply {
            this.name = topic.name
        }
        val saved = topicRepository.save(topicEntity)
        return TopicResponse(saved)
    }

    @Transactional
    override fun deleteTopicById(id: Int) {
        topicRepository.deleteById(id)
    }

    @Transactional
    override fun updateTopicById(id: Int, updatedTopic: TopicDto) {
        val topicEntity = findById(id)
        topicEntity.name = updatedTopic.name
    }

    @Transactional
    override fun findById(id: Int): TopicEntity {
        val optionalTopic = topicRepository.findById(id)
        val topic = if (!optionalTopic.isPresent){
            throw BadRequestException("Topic with id $id not found")
        } else {
            optionalTopic.get()
        }
        return topic
    }

    @Transactional
    override fun findByIds(idList: List<Int>): List<TopicEntity> {
        val topicList = idList.map { id ->
            findById(id)
        }.toMutableList()
        return topicList
    }
}