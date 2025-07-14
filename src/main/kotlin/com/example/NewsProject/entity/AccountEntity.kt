package com.example.NewsProject.entity

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.DiscriminatorType
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import java.util.UUID

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("ACCOUNT")
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING, length = 20)
abstract class AccountEntity {
    @Id
    @Column(name = "id")
    var id: UUID? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "mail")
    var mail: String? = null
}