package com.example.NewsProject.dao

import com.example.NewsProject.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AccountRepository: JpaRepository<AccountEntity, UUID> {
    fun findByName(username: String): AccountEntity?
}