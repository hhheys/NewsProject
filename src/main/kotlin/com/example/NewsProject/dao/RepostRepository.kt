package com.example.NewsProject.dao

import com.example.NewsProject.entity.RepostEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RepostRepository : JpaRepository<RepostEntity, UUID> {
}