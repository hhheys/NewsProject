package com.example.NewsProject.controllers

import com.example.NewsProject.dto.TopicDto
import com.example.NewsProject.response.TopicResponse
import com.example.NewsProject.service.TopicServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
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
@Tag(name = "Topic", description = "Логика взаимодействия с топиками.")
class TopicController(
    private val topicService: TopicServiceImpl
) {
    @GetMapping("/{id}")
    @Operation(summary = "Получение топика по его ID.")
    fun getTopic(@PathVariable id: Int) : TopicResponse {
        return TopicResponse(topicService.findById(id))
    }

    @GetMapping("/all")
    @Operation(summary = "Получение всех топиков.")
    fun getTopics() : List<TopicResponse> {
        return topicService.getAllTopics()
    }

    @PostMapping("/create")
    @Operation(summary = "Создание топика.")
    fun createTopic(@RequestBody topicDto: TopicDto): TopicResponse {
        return topicService.createTopic(topicDto)
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление топика.")
    fun deleteTopic(@PathVariable id: Int) {
        topicService.deleteTopicById(id)
    }

    @PatchMapping("update/{id}")
    @Operation(summary = "Обновление названия топика.")
    fun updateTopic(@PathVariable id: Int, @RequestBody topicDto: TopicDto) {
        topicService.updateTopicById(id, topicDto)
    }
}