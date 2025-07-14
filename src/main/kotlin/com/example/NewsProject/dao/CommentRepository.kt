package com.example.NewsProject.dao

import com.example.NewsProject.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CommentRepository: JpaRepository<CommentEntity, UUID> {
}