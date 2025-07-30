package com.example.NewsProject.service

import com.example.NewsProject.dao.AccountRepository
import com.example.NewsProject.entity.AccountEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository
): AccountService {
    @Transactional
    override fun findByName(name: String): AccountEntity? {
        return accountRepository.findByName(name)
    }
}