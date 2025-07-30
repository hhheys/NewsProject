package com.example.NewsProject.service

import com.example.NewsProject.entity.AccountEntity

interface AccountService {
    fun findByName(name: String): AccountEntity?
}