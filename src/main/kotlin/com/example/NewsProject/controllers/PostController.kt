package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.PostCreateDto
import com.example.NewsProject.dto.PostUpdateDto
import com.example.NewsProject.entity.AccountEntity
import com.example.NewsProject.response.PostResponse
import com.example.NewsProject.service.redis.RedisService
import com.example.NewsProject.service.post.PostServiceImpl
import org.apache.coyote.BadRequestException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostServiceImpl,
    private val redisProducerService: RedisService,
) {
    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_${AccountTypes.PUBLISHER}')")
    fun createPost(@RequestBody postCreateDto: PostCreateDto, @AuthenticationPrincipal accountDetails: AccountEntity): PostResponse{
        val uuid = accountDetails.id ?: throw BadRequestException("Account uuid not found")
        return postService.createPost(postCreateDto, uuid)
    }

    @GetMapping("/{uuid}")
    fun getPostByUUID(@PathVariable uuid: UUID): PostResponse {
        redisProducerService.sendMessage("views", mapOf(
            "postUUID" to uuid.toString()
        ))
        return PostResponse(postService.findById(uuid))
    }

    @PatchMapping("/update/{uuid}")
    fun updatePost(@PathVariable uuid: UUID, @RequestBody postUpdateDto: PostUpdateDto): PostResponse{
        return postService.updateById(uuid, postUpdateDto)
    }

    @DeleteMapping("/delete/{uuid}")
    fun deletePostByUUID(@PathVariable uuid: UUID) {
        postService.deleteById(uuid)
    }

    @GetMapping
    fun findPostsByTopicId(@RequestParam("topicId") topicId: Int?): List<PostResponse> {
        if (topicId == null) {
            return postService.findAll()
        }
        return postService.findPostsByTopicId(topicId)
    }
}