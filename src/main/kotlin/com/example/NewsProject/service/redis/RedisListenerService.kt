package com.example.NewsProject.service.redis

import com.example.NewsProject.service.ReactionServiceImpl
import com.example.NewsProject.service.post.PostViewServiceImpl
import org.apache.coyote.BadRequestException
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.*

@Service
class RedisListenerService(
    private val redisService: RedisService,
    private val postReactionService: ReactionServiceImpl,
    private val postViewService: PostViewServiceImpl
) {
    @Scheduled(fixedDelay = 3000)
    @Async
    fun reactionsListener() {
        val records = redisService.readMessages("reactions", "reactions-group") ?: return
        for (record in records){
            val type = record.value["reactionType"] ?: continue
            val postUUID = UUID.fromString(record.value["postUUID"]) ?: throw BadRequestException()
            val userUUID = UUID.fromString(record.value["userUUID"]) ?: throw BadRequestException()

            when (type) {
                "like" -> postReactionService.addLike(postUUID, userUUID)
                "dislike" -> postReactionService.addDislike(postUUID, userUUID)
                else -> continue
            }
        }
    }

    @Scheduled(fixedDelay = 3000)
    @Async
    fun viewsListener() {
        val records = redisService.readMessages("views", "views-group") ?: return
        for (record in records){
            val postUUID = UUID.fromString(record.value["postUUID"]) ?: continue
            postViewService.incrementView(postUUID)
        }
    }
}