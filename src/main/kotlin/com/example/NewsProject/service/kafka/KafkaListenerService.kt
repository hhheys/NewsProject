package com.example.NewsProject.service.kafka

import com.example.NewsProject.consts.EventType
import com.example.NewsProject.dto.CreateCommentDto
import com.example.NewsProject.dto.kafka.CommentEvent
import com.example.NewsProject.dto.kafka.ReactionEvent
import com.example.NewsProject.dto.kafka.PostEvent
import com.example.NewsProject.dto.kafka.ViewEvent
import com.example.NewsProject.handlers.exceptions.BadRequestException
import com.example.NewsProject.service.CommentServiceImpl
import com.example.NewsProject.service.ReactionServiceImpl
import com.example.NewsProject.service.post.PostViewServiceImpl
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

import kotlinx.serialization.modules.polymorphic

val json = Json {
    ignoreUnknownKeys = true
    classDiscriminator = "type" // <- поле JSON, которое указывает на конкретный класс
    serializersModule = SerializersModule {
        polymorphic(PostEvent::class) {
            subclass(ViewEvent::class, ViewEvent.serializer())
            subclass(ReactionEvent::class, ReactionEvent.serializer())
            subclass(CommentEvent::class, CommentEvent.serializer())
        }
    }
}

@Service
class KafkaListenerService(
    private val postReactionService: ReactionServiceImpl,
    private val postViewService: PostViewServiceImpl,
    private val commentService: CommentServiceImpl
) {
    @KafkaListener(topics = ["post-events"], groupId = "post-event-group")
    fun listenEvents(message: String){
        val event = json.decodeFromString<PostEvent>(message)
        when(event){
            is ViewEvent -> postViewService.incrementView(event.postUUID)
            is ReactionEvent -> {
                when(event.eventType){
                    EventType.LIKE -> postReactionService.addLike(event.postUUID, event.userUUID)
                    EventType.DISLIKE -> postReactionService.addDislike(event.postUUID, event.userUUID)
                    else -> throw BadRequestException("Reaction type is incorrect")
                }
            }
            is CommentEvent -> {
                commentService.createComment(CreateCommentDto(event), event.userUUID)
            }
        }
    }
}