package com.example.NewsProject.service.kafka

import com.example.NewsProject.consts.EventType
import com.example.NewsProject.dto.CreateCommentDto
import com.example.NewsProject.dto.PostReactionDto
import com.example.NewsProject.dto.kafka.CommentEvent
import com.example.NewsProject.dto.kafka.PostEvent
import com.example.NewsProject.dto.kafka.ReactionEvent
import com.example.NewsProject.dto.kafka.ViewEvent
import com.example.NewsProject.handlers.exceptions.BadRequestException
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, PostEvent>
) {
    private fun sendMessage(topic: String, event: PostEvent){
        kafkaTemplate.send(topic, event)
    }

    fun incrementView(postUUID: UUID){
        val event = ViewEvent(postUUID = postUUID)
        sendMessage("post-events", event)
    }

    fun addReaction(reactionDto: PostReactionDto, userUUID: UUID){
        val eventType = when (reactionDto.type){
            "like" -> EventType.LIKE
            "dislike" -> EventType.DISLIKE
            else -> throw BadRequestException("Reaction type is incorrect")
        }
        val event = ReactionEvent(eventType, reactionDto.postUUID, userUUID)
        sendMessage("post-events", event)
    }

    fun addComment(commentDto: CreateCommentDto, userUUID: UUID){
        val event = CommentEvent(postUUID = commentDto.postUUID, userUUID = userUUID, content = commentDto.content)
        sendMessage("post-events", event)
    }
}