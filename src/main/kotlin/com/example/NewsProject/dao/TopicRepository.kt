package com.example.NewsProject.dao

import com.example.NewsProject.entity.TopicEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TopicRepository: JpaRepository<TopicEntity, UUID> {
}