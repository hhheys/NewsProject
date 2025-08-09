package com.example.NewsProject.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "comment")
class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: UUID? = null

    @Column(name = "content")
    var content: String? = null

    @ManyToOne
    @JoinColumn(
        name = "user_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "comment_entity_user_uuid_fk")
    )
    var user: UserEntity? = null

    @ManyToOne
    @JoinColumn(
        name = "post_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "comment_entity_post_uuid_fk")
    )
    var post: PostEntity? = null
}