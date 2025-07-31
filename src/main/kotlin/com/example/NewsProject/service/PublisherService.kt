package com.example.NewsProject.service

import com.example.NewsProject.entity.PublisherEntity
import com.example.NewsProject.dto.PublisherDto
import java.util.UUID

interface PublisherService {
    fun addPublisher(publisher: PublisherDto)
    fun findById(uuid: UUID): PublisherEntity
}