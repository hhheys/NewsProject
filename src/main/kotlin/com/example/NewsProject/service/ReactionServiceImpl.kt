package com.example.NewsProject.service

import com.example.NewsProject.dao.DislikeRepository
import com.example.NewsProject.dao.LikeRepository
import com.example.NewsProject.dao.ReactionRepository
import com.example.NewsProject.entity.DislikeEntity
import com.example.NewsProject.entity.LikeEntity
import com.example.NewsProject.entity.ReactionEntity
import com.example.NewsProject.response.PostReactionResponse
import com.example.NewsProject.service.post.PostServiceImpl
import jakarta.transaction.Transactional
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ReactionServiceImpl(
    private val postService: PostServiceImpl,
    private val userService: UserServiceImpl,
    private val likeRepository: LikeRepository,
    private val dislikeRepository: DislikeRepository,
    private val reactionRepository: ReactionRepository
): ReactionService {
    @Transactional
    override fun addLike(postUUID: UUID, userUUID: UUID): PostReactionResponse {
        val post = postService.findById(postUUID)
        val user = userService.findById(userUUID)
        println(user)
        val like = LikeEntity().apply {
            this.post = post
            this.user = user
        }
        val saved = likeRepository.save(like)
        return PostReactionResponse(saved, "like")
    }

    @Transactional
    override fun addDislike(postUUID: UUID, userUUID: UUID): PostReactionResponse {
        val post = postService.findById(postUUID)
        val user = userService.findById(userUUID)
        println(user)
        val dislike = DislikeEntity().apply {
            this.post = post
            this.user = user
        }
        val saved = dislikeRepository.save(dislike)
        return PostReactionResponse(saved, "dislike")
    }

    override fun findById(reactionUUID: UUID): ReactionEntity {
        val optionalReaction = reactionRepository.findById(reactionUUID)
        if (optionalReaction.isPresent){
            return optionalReaction.get()
        }
        throw BadRequestException("Reaction not found")
    }

    override fun findByPostUUIDandUserUUID(postUUID: UUID, userUUID: UUID): ReactionEntity? {
        return reactionRepository.findFirstByPost_IdAndUser_Id(postUUID, userUUID)
    }


}