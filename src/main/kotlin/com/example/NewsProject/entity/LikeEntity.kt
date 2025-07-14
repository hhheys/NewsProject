package com.example.NewsProject.entity

import com.example.NewsProject.consts.ReactionTypes.LIKE
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "like")
@PrimaryKeyJoinColumn(referencedColumnName = "id", foreignKey = ForeignKey(name = "like_reacrion_fk"))
@DiscriminatorValue(LIKE)
class LikeEntity: ReactionEntity() {
}