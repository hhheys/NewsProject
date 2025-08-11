package com.example.NewsProject.entity

import com.example.NewsProject.consts.ReactionTypes.DISLIKE
import jakarta.persistence.*

@Entity
@Table(name = "dislike")
//@PrimaryKeyJoinColumn(referencedColumnName = "reaction_uuid", foreignKey = ForeignKey(name = "dislike_reaction_fk"))
@DiscriminatorValue(DISLIKE)
@PrimaryKeyJoinColumn(
    name = "reaction_uuid",
    referencedColumnName = "id",
    foreignKey = ForeignKey(name = "dislike_reaction_fk")
)
class DislikeEntity : ReactionEntity() {

}