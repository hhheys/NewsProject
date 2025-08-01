package com.example.NewsProject.dao

import com.example.NewsProject.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PostRepository : JpaRepository<PostEntity, UUID> {
}