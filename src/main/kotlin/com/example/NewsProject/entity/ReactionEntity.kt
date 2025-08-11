package com.example.NewsProject.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "reaction")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("RAEACTION")
@DiscriminatorColumn(name = "reaction_type", discriminatorType = DiscriminatorType.STRING, length = 20)
class ReactionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @ManyToOne
    @JoinColumn(
        name = "post_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "reaction_entity_post_fk")
    )
    var post: PostEntity? = null

    @ManyToOne
    @JoinColumn(
        name = "user_uuid",
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "resction_entity_user_fk")
    )
    var user: UserEntity? = null

    @Column(name = "reaction_type", insertable = false, updatable = false)
    var reactionType: String? = null
}