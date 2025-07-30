package com.example.NewsProject.entity

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.DiscriminatorType
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "reaction")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorValue("RAEACTION")
//@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING, length = 20)
class ReactionEntity {
    @Id
    @Column(name = "id")
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
}