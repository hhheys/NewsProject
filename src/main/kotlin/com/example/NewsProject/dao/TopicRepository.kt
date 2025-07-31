package com.example.NewsProject.dao

import com.example.NewsProject.entity.TopicEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<TopicEntity, Int> {
}