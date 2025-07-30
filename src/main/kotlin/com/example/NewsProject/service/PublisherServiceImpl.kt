package com.example.NewsProject.service

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dao.PublisherRepository
import com.example.NewsProject.dao.UserRepository
import com.example.NewsProject.dto.PublisherDto
import com.example.NewsProject.entity.PublisherEntity
import org.springframework.stereotype.Service

@Service
class PublisherServiceImpl(
    private val publisherRepository: PublisherRepository
): PublisherService {
    override fun addPublisher(publisher: PublisherDto) {
        val publisherEntity = PublisherEntity().apply {
            this.name = publisher.name
            this.password = publisher.password
            this.email = publisher.email
            this.legalName = publisher.legalName
            this.legalAddress = publisher.legalAddress
            this.accountType = AccountTypes.PUBLISHER
        }
        publisherRepository.save(publisherEntity)
    }
}