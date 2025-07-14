package com.example.NewsProject.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "repost")
class RepostEntity {
    @Id
    @Column(name = "id")
    val id: UUID? = null

    @ManyToOne
    @JoinColumn(
        name = "post_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "repost_entity_post_uuid_fk")
    )
    val post: PostEntity? = null

    @ManyToOne
    @JoinColumn(
        name = "sender_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "repost_entity_sender_uuid_fk")
    )
    val sender: UserEntity? = null

    @ManyToOne
    @JoinColumn(
        name = "recipient_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "repost_entity_recipient_uuid_fk")
    )
    val recipient: UserEntity? = null
}