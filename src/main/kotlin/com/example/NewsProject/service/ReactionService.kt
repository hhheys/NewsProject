package com.example.NewsProject.service

import com.example.NewsProject.entity.ReactionEntity
import com.example.NewsProject.response.PostReactionResponse
import java.util.*

interface ReactionService {
    fun addLike(postUUID: UUID, userUUID: UUID): PostReactionResponse?
    fun addDislike(postUUID: UUID, userUUID: UUID): PostReactionResponse?
    fun findById(reactionUUID: UUID): ReactionEntity
    fun findByPostUUIDandUserUUID(postUUID: UUID, userUUID: UUID): ReactionEntity?
}