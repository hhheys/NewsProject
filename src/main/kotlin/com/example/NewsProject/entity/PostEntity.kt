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

    @ManyToMany
    @JoinTable(
        name = "post_topic",
        joinColumns = [JoinColumn(name = "post_uuid")],
        inverseJoinColumns = [JoinColumn(name = "topic_id")]
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