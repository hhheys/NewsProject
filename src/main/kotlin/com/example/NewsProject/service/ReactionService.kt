package com.example.NewsProject.service

import com.example.NewsProject.entity.ReactionEntity
import com.example.NewsProject.response.PostReactionResponse
import com.example.NewsProject.response.ReactionResponse
import java.util.*

interface ReactionService {
    fun addLike(postUUID: UUID, userUUID: UUID): PostReactionResponse?
    fun addDislike(postUUID: UUID, userUUID: UUID): PostReactionResponse?
    fun findById(reactionUUID: UUID): ReactionEntity
    fun findByPostUUIDandUserUUID(postUUID: UUID, userUUID: UUID): ReactionEntity?
    fun removeReaction(reactionUUID: UUID, userUUID: UUID)
    fun findAllByPostId(postUUID: UUID): MutableList<ReactionResponse>
    fun getAllReactionsByUserId(userId: UUID): List<ReactionResponse>
}