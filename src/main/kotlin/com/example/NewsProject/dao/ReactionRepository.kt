package com.example.NewsProject.dao

import com.example.NewsProject.entity.ReactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface ReactionRepository: JpaRepository<ReactionEntity, UUID> {
    fun findFirstByPost_IdAndUser_Id(postId: UUID, userId: UUID): ReactionEntity?
    fun findAllByPost_Id(postId: UUID): List<ReactionEntity>?
    fun getAllByUser_Id(userId: UUID): List<ReactionEntity>
}