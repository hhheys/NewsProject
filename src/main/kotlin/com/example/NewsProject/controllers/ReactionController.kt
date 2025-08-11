package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.PostReactionDto
import com.example.NewsProject.entity.AccountEntity
import com.example.NewsProject.service.ReactionServiceImpl
import com.example.NewsProject.service.redis.RedisService
import org.apache.coyote.BadRequestException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reaction")
class ReactionController(
    private val redisProducerService: RedisService,
    private val reactionService: ReactionServiceImpl
) {
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_${AccountTypes.USER}')")
    fun addReactionPost(@RequestBody postReactionDto: PostReactionDto, @AuthenticationPrincipal accountDetails: AccountEntity){
        if (postReactionDto.type !in listOf("like","dislike")){
            throw BadRequestException("Reaction type not found")
        }
        if (reactionService.findByPostUUIDandUserUUID(postReactionDto.postUUID, accountDetails.id!!) != null){
            throw BadRequestException("Reaction is already added")
        }
        redisProducerService.sendMessage("reactions", mapOf(
            "postUUID" to postReactionDto.postUUID.toString(),
            "userUUID" to accountDetails.id.toString(),
            "reactionType" to postReactionDto.type
        ))

    }
}