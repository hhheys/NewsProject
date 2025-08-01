package com.example.NewsProject.controllers

import com.example.NewsProject.dto.PostCreateDto
import com.example.NewsProject.dto.PostUpdateDto
import com.example.NewsProject.entity.AccountEntity
import com.example.NewsProject.response.PostResponse
import com.example.NewsProject.response.TopicResponse
import com.example.NewsProject.service.PostServiceImpl
import org.apache.coyote.BadRequestException
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostServiceImpl
) {
    @PostMapping("/create")
    fun createPost(@RequestBody postCreateDto: PostCreateDto, @AuthenticationPrincipal accountDetails: AccountEntity): PostResponse{
        val uuid = accountDetails.id ?: throw BadRequestException("Account uuid not found")
        return postService.createPost(postCreateDto, uuid)
    }

    @GetMapping
    fun getAllPosts(): MutableList<PostResponse> {
        return postService.findAll()
    }

    @GetMapping("/{uuid}")
    fun getPostByUUID(@PathVariable uuid: UUID): PostResponse {
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

    @GetMapping("&topic_id={topicId}")
    fun findPostsByTopic(@RequestBody posts: List<PostResponse>, @RequestBody topics: List<TopicResponse>, @PathVariable topicId: Int) {
        postService.findPostsByTopicId(posts, topics, topicId)
    }
}