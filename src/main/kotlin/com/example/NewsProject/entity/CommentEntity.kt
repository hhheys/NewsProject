package com.example.NewsProject.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "comment")
class CommentEntity {
    @Id
    @Column(name = "id")
    val id: UUID? = null

    @Column(name = "content")
    val content: String? = null

    @ManyToOne
    @JoinColumn(
        name = "user_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "comment_entity_user_uuid_fk")
    )
    val user: UserEntity? = null

    @ManyToOne
    @JoinColumn(
        name = "post_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "comment_entity_post_uuid_fk")
    )
    val post: PostEntity? = null
}