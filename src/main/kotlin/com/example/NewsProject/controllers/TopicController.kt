package com.example.NewsProject.controllers

import com.example.NewsProject.dto.TopicDto
import com.example.NewsProject.response.TopicResponse
import com.example.NewsProject.service.TopicServiceImpl
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicServiceImpl
) {
    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Int) : TopicResponse {
        return TopicResponse(topicService.findById(id))
    }

    @GetMapping("/all")
    fun getTopics() : List<TopicResponse> {
        return topicService.getAllTopics()
    }

    @PostMapping("/create")
    fun createTopic(@RequestBody topicDto: TopicDto): TopicResponse {
        return topicService.createTopic(topicDto)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteTopic(@PathVariable id: Int) {
        topicService.deleteTopicById(id)
    }

    @PatchMapping("update/{id}")
    fun updateTopic(@PathVariable id: Int, @RequestBody topicDto: TopicDto) {
        topicService.updateTopicById(id, topicDto)
    }
}