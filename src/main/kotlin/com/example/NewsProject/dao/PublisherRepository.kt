package com.example.NewsProject.dao

import com.example.NewsProject.entity.PublisherEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PublisherRepository : JpaRepository<PublisherEntity, UUID> {
}