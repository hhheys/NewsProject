package com.example.NewsProject.service

import com.example.NewsProject.dao.CommentRepository
import com.example.NewsProject.dto.CreateCommentDto
import com.example.NewsProject.entity.CommentEntity
import com.example.NewsProject.response.CommentResponse
import com.example.NewsProject.service.post.PostServiceImpl
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val postService: PostServiceImpl,
    private val userService: UserServiceImpl
): CommentService {
    @Transactional
    override fun createComment(commentDto: CreateCommentDto, userUUID: UUID): CommentResponse {
        val post = postService.findById(commentDto.postUUID)
        val user = userService.findById(userUUID)
        val comment = CommentEntity().apply {
            this.post = post
            this.user = user
            this.content = commentDto.content
        }
        val saved = commentRepository.save(comment)
        return CommentResponse(saved)
    }
}