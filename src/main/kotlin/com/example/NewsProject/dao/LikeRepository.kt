package com.example.NewsProject.dao

import com.example.NewsProject.entity.LikeEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface LikeRepository: JpaRepository<LikeEntity, UUID> {
}