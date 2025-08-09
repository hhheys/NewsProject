package com.example.NewsProject.service

import com.example.NewsProject.dto.CreateCommentDto
import com.example.NewsProject.response.CommentResponse
import java.util.*

interface CommentService {
    fun createComment(commentDto: CreateCommentDto, userUUID: UUID): CommentResponse
}