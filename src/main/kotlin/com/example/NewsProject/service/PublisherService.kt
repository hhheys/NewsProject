package com.example.NewsProject.service

import com.example.NewsProject.dto.AccountDto
import com.example.NewsProject.entity.PublisherEntity
import com.example.NewsProject.response.PublisherResponse
import java.util.UUID

interface PublisherService {
    fun addPublisher(publisher: AccountDto): PublisherResponse
    fun findById(uuid: UUID): PublisherEntity
}