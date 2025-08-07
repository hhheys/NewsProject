package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.CreateCommentDto
import com.example.NewsProject.entity.AccountEntity
import com.example.NewsProject.response.CommentResponse
import com.example.NewsProject.service.CommentServiceImpl
import org.apache.coyote.BadRequestException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comment")
class CommentController(
    private val commentService: CommentServiceImpl
) {
    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_${AccountTypes.USER}', 'ROLE_${AccountTypes.PUBLISHER}')")
    fun addComment(@RequestBody commentDto: CreateCommentDto, @AuthenticationPrincipal accountDetails: AccountEntity): CommentResponse{
        val uuid = accountDetails.id ?: throw BadRequestException("Account uuid not found")
        return commentService.createComment(commentDto, uuid)
    }
}