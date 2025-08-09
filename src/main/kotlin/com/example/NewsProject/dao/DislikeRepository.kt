package com.example.NewsProject.dao

import com.example.NewsProject.entity.DislikeEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DislikeRepository : JpaRepository<DislikeEntity, UUID> {
}