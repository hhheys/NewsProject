package com.example.NewsProject.entity

import com.example.NewsProject.consts.AccountTypes.USER
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "user_entity")
@PrimaryKeyJoinColumn(referencedColumnName = "id", foreignKey = ForeignKey(name = "user_account_fk"))
@DiscriminatorValue(USER)
class UserEntity() : AccountEntity() {
    @Column(name = "role")
    var role: String? = null
}