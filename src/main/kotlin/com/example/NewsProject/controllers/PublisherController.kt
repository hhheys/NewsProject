package com.example.NewsProject.controllers

import com.example.NewsProject.dto.PublisherDto
import com.example.NewsProject.response.PublisherResponse
import com.example.NewsProject.service.PublisherServiceImpl
import jakarta.validation.Valid
import org.apache.coyote.BadRequestException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/publishers")
class PublisherController(
    private val publisherService: PublisherServiceImpl
) {
        @PostMapping("/create")
        fun createPublisher(@RequestBody @Valid publisherDto: PublisherDto): PublisherResponse {
            try{
                return publisherService.addPublisher(publisherDto)
            }catch (_: Exception){
                throw BadRequestException("Failed to create publisher")
            }
        }
}