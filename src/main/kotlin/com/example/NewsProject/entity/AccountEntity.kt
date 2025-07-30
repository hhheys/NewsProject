package com.example.NewsProject.entity

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.DiscriminatorType
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("ACCOUNT")
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING, length = 20)
abstract class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    var id: UUID? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "password")
    var password: String? = null

    @Column(name = "email")
    var email: String? = null

    @Column(name = "account_type", insertable = false, updatable = false)
    var accountType: String? = null
}