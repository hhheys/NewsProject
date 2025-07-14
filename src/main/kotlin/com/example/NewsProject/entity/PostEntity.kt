package com.example.NewsProject.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "post")
class PostEntity {
    @Id
    @Column(name = "id")
    val id: UUID? = null

    @Column(name = "title")
    val title: String? = null

    @Column(name = "description")
    val description: String? = null

    @Column(name = "content")
    val content: String? = null

    @Column(name = "view_count")
    val viewCount: Long? = null

    @OneToMany
    @JoinColumn(
        name = "topic_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "post_entity_topic_id_fk")
    )
    val topic: MutableList<TopicEntity>? = null

    @Transient
    @OneToMany
    val comments: MutableList<CommentEntity>? = null

    @ManyToOne
    @JoinColumn(
        name = "publisher_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "post_entity_publisher_fk")
    )
    var publisher: PublisherEntity? = null
}