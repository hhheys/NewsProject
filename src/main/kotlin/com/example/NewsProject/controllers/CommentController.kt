package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.CreateCommentDto
import com.example.NewsProject.entity.AccountEntity
import com.example.NewsProject.service.kafka.KafkaService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.coyote.BadRequestException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comment")
@Tag(name = "Comments", description = "Логика взаимодействия с комментариями.")
class CommentController(
    private val kafkaService: KafkaService
) {
    @PostMapping("/add")
    @Operation(summary = "Создание комментария.")
    @PreAuthorize("hasAnyRole('ROLE_${AccountTypes.USER}', 'ROLE_${AccountTypes.PUBLISHER}')")
    fun addComment(@RequestBody commentDto: CreateCommentDto, @AuthenticationPrincipal accountDetails: AccountEntity){
        val uuid = accountDetails.id ?: throw BadRequestException("Account uuid not found")
        kafkaService.addComment(commentDto, uuid)
//        return commentService.createComment(commentDto, uuid)
    }
}