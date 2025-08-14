package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.PostCreateDto
import com.example.NewsProject.dto.PostUpdateDto
import com.example.NewsProject.entity.AccountEntity
import com.example.NewsProject.response.PostResponse
import com.example.NewsProject.service.kafka.KafkaService
import com.example.NewsProject.service.post.PostServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.coyote.BadRequestException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/posts")
@Tag(name = "Post", description = "Логика взаимодействия с постами.")
class PostController(
    private val postService: PostServiceImpl,
    private val kafkaService: KafkaService
) {
    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_${AccountTypes.PUBLISHER}')")
    @Operation(summary = "Создание поста.")
    fun createPost(@RequestBody postCreateDto: PostCreateDto, @AuthenticationPrincipal accountDetails: AccountEntity): PostResponse{
        val uuid = accountDetails.id ?: throw BadRequestException("Account uuid not found")
        return postService.createPost(postCreateDto, uuid)
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Получение поста по его UUID.")
    fun getPostByUUID(@PathVariable uuid: UUID): PostResponse {
        kafkaService.incrementView(uuid)
        return PostResponse(postService.findById(uuid))
    }

    @PatchMapping("/update/{uuid}")
    @Operation(summary = "Обновление полей поста по UUID.")
    fun updatePost(@PathVariable uuid: UUID, @RequestBody postUpdateDto: PostUpdateDto): PostResponse{
        return postService.updateById(uuid, postUpdateDto)
    }

    @DeleteMapping("/delete/{uuid}")
    @Operation(summary = "Удаление поста по UUID")
    fun deletePostByUUID(@PathVariable uuid: UUID) {
        postService.deleteById(uuid)
    }

    @GetMapping
    @Operation(summary = "Получение всех постов с логикой сортировки.")
    fun findPostsByTopicId(@RequestParam("topicId") topicId: Int?): List<PostResponse> {
        if (topicId == null) {
            return postService.findAll()
        }
        return postService.findPostsByTopicId(topicId)
    }
}