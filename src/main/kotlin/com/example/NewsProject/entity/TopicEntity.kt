package com.example.NewsProject.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "topic")
class TopicEntity {
    @Id
    @Column(name = "id")
    val id: Int? = null

    @Column
    val name: String? = null

    @Transient
    @ManyToMany(mappedBy = "topic")
    var post: MutableList<PostEntity>? = null
}