package com.example.NewsProject.service

import com.example.NewsProject.dao.PublisherRepository
import com.example.NewsProject.entity.PublisherEntity
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service
import java.util.*

@Service
class PublisherServiceImpl(
    private val publisherRepository: PublisherRepository
): PublisherService {
    override fun findById(uuid: UUID): PublisherEntity {
        val publisherOptional = publisherRepository.findById(uuid)

        val publisher = if (publisherOptional.isPresent){
            publisherOptional.get()
        } else {
            throw BadRequestException("Publisher not found")
        }
        return publisher
    }
}