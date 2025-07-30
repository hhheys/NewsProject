package com.example.NewsProject.controllers

import com.example.NewsProject.dto.PublisherDto
import com.example.NewsProject.service.PublisherService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/publishers")
class PublisherController(
    private val publisherService: PublisherService
) {
    @PostMapping
    fun createPublisher(@RequestBody publisherDto: PublisherDto) {
        publisherService.addPublisher(publisherDto)
    }
}