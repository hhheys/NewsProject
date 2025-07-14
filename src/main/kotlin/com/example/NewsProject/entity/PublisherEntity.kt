package com.example.NewsProject.entity

import com.example.NewsProject.consts.AccountTypes.PUBLISHER
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.OneToMany
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "publisher")
@PrimaryKeyJoinColumn(referencedColumnName = "id",foreignKey = ForeignKey(name = "publisher_account_fk"))
@DiscriminatorValue(PUBLISHER)
class PublisherEntity: AccountEntity() {
    @Column(name = "legal_name")
    var legalName: String? = null

    @Column(name = "legal_adress")
    var legalAdress: String? = null

    @OneToMany
    @Transient
    var postEntities: MutableList<PostEntity> = mutableListOf()
}