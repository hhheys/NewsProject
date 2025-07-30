package com.example.NewsProject.service

import com.example.NewsProject.dto.PublisherDto

interface PublisherService {
    fun addPublisher(publisher: PublisherDto)
}