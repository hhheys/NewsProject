package com.example.NewsProject.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "topic")
class TopicEntity {
    @Id
    @Column(name = "id")
    val id: UUID? = null

    @Column
    val name: String? = null
}