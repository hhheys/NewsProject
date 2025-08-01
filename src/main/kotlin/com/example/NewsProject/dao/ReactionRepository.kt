package com.example.NewsProject.dao

import com.example.NewsProject.entity.ReactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReactionRepository : JpaRepository<ReactionEntity, UUID> {
}