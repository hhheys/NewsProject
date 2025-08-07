package com.example.NewsProject.service.post

import com.example.NewsProject.dto.PostCreateDto
import com.example.NewsProject.dto.PostUpdateDto
import com.example.NewsProject.entity.PostEntity
import com.example.NewsProject.response.PostResponse
import java.util.UUID

interface PostService {
    fun createPost(postCreateDto: PostCreateDto, publisherUUID: UUID): PostResponse
    fun findById(id: UUID): PostEntity
    fun findAll(): List<PostResponse>
    fun updateById(id: UUID, postUpdateDto: PostUpdateDto): PostResponse
    fun deleteById(id: UUID)
    fun incrementView(id: UUID)
}