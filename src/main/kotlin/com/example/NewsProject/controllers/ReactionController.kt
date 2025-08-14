package com.example.NewsProject.controllers

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dto.PostReactionDto
import com.example.NewsProject.entity.AccountEntity
import com.example.NewsProject.response.ReactionResponse
import com.example.NewsProject.service.ReactionServiceImpl
import com.example.NewsProject.service.kafka.KafkaService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.coyote.BadRequestException
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/reaction")
@Tag(name = "Reaction", description = "Логика взаимодействия с реакциями.")
class ReactionController(
    private val reactionService: ReactionServiceImpl,
    private val kafkaService: KafkaService
) {
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_${AccountTypes.USER}')")
    @Operation(summary = "Добавление реакции на пост.")
    fun addReactionPost(@RequestBody postReactionDto: PostReactionDto, @AuthenticationPrincipal accountDetails: AccountEntity){
        if (postReactionDto.type !in listOf("like","dislike")){
            throw BadRequestException("Reaction type not found")
        }
        if (reactionService.findByPostUUIDandUserUUID(postReactionDto.postUUID, accountDetails.id!!) != null){
            throw BadRequestException("Reaction is already added")
        }
        kafkaService.addReaction(postReactionDto, accountDetails.id!!)
    }

    @DeleteMapping("/remove/{uuid}")
    @Operation(summary = "Удаление реакции с поста.")
    @PreAuthorize("hasAnyRole('ROLE_${AccountTypes.USER}', 'ROLE_${AccountTypes.PUBLISHER}')")
    fun removeReaction(@PathVariable uuid: UUID, @AuthenticationPrincipal accountDetails: AccountEntity){
        val accountUUID = accountDetails.id ?: throw BadRequestException()
        reactionService.removeReaction(uuid, accountUUID)
    }

    @GetMapping("/post/{uuid}")
    @Operation(summary = "Получение реакций по UUID поста.")
    fun getReactionsByPostID(@PathVariable uuid: UUID): MutableList<ReactionResponse> {
        return reactionService.findAllByPostId(uuid)
    }
}