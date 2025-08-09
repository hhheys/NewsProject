package com.example.NewsProject.dao

import com.example.NewsProject.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PostRepository : JpaRepository<PostEntity, UUID> {
//    @Query(value = "SELECT p.* FROM post p JOIN post_topic pt ON p.id = pt.post_uuid WHERE pt.topic_id = :topicId", nativeQuery = true)
    fun findAllByTopic_Id(topicId: Int): List<PostEntity>
}