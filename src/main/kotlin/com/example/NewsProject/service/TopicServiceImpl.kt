package com.example.NewsProject.service

import com.example.NewsProject.dao.TopicRepository
import com.example.NewsProject.entity.TopicEntity
import jakarta.transaction.Transactional
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private val topicRepository: TopicRepository
): TopicService {
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