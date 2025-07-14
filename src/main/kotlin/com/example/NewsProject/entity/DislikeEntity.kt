package com.example.NewsProject.entity

import com.example.NewsProject.consts.ReactionTypes.DISLIKE
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "dislike")
@PrimaryKeyJoinColumn(referencedColumnName = "id", foreignKey = ForeignKey(name = "dislike_reaction_fk"))
@DiscriminatorValue(DISLIKE)
class DislikeEntity: ReactionEntity() {
}