package com.example.NewsProject.service

import com.example.NewsProject.entity.PublisherEntity
import java.util.UUID

interface PublisherService {
    fun findById(uuid: UUID): PublisherEntity
}