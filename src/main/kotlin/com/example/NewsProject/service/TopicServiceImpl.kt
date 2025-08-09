package com.example.NewsProject.service

import com.example.NewsProject.dao.TopicRepository
import com.example.NewsProject.dto.TopicDto
import com.example.NewsProject.entity.TopicEntity
import com.example.NewsProject.response.TopicResponse
import jakarta.transaction.Transactional
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private val topicRepository: TopicRepository
) : TopicService {
    @Transactional
    override fun getTopicById(id: Int): TopicResponse {
        val optionalTopic = topicRepository.findById(id)
        return if (optionalTopic.isPresent) {
            val topic = optionalTopic.get()
            TopicResponse(topic)
        } else {
            throw BadRequestException("No topic with this id")
        }
    }

    @Transactional
    override fun getAllTopics(): List<TopicResponse> {
        return topicRepository.findAll().map { TopicResponse(it) }
    }

    @Transactional
    override fun createTopic(topic: TopicDto) {
        val topicEntity = TopicEntity().apply {
            this.name = topic.name
        }
        topicRepository.save(topicEntity)
    }

    @Transactional
    override fun deleteTopicById(id: Int) {
        topicRepository.deleteById(id)
    }

    @Transactional
    override fun updateTopicById(id: Int, updatedTopic: TopicDto) {
        val topicEntity = getTopicById(id)
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