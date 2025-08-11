package com.example.NewsProject.entity

import jakarta.persistence.*
import org.hibernate.annotations.Formula
import java.util.UUID

@Entity
@Table(name = "post")
class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    var id: UUID? = null

    @Column(name = "title")
    var title: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "content")
    var content: String? = null

    @Column(name = "view_count")
    var viewCount: Long? = 0

    @ManyToMany
    @JoinTable(
        name = "post_topic",
        joinColumns = [JoinColumn(name = "post_uuid")],
        inverseJoinColumns = [JoinColumn(name = "topic_id")]
    )
    var topic: MutableList<TopicEntity>? = null

//    @Transient
//    @OneToMany
//    var comments: MutableList<CommentEntity>? = null

    @ManyToOne
    @JoinColumn(
        name = "publisher_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "post_entity_publisher_fk")
    )
    var publisher: PublisherEntity? = null

    @Formula("(select count(l.reaction_uuid) " +
            "from like_entity l " +
            "join reaction r on l.reaction_uuid = r.id " +
            "where r.post_uuid = id)")
    var likeCount: Long = 0

    @Formula("(select count(l.reaction_uuid) " +
            "from dislike l " +
            "join reaction r on l.reaction_uuid = r.id " +
            "where r.post_uuid = id)")
    var dislikeCount: Long = 0
}