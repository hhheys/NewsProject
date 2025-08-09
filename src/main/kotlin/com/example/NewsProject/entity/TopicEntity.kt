package com.example.NewsProject.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "topic")
class TopicEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column
    var name: String? = null

    @Transient
    @ManyToMany(mappedBy = "topic")
    var post: MutableList<PostEntity>? = null
}