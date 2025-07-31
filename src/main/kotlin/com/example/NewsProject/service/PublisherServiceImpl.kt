package com.example.NewsProject.service

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.dao.PublisherRepository
import com.example.NewsProject.entity.PublisherEntity
import com.example.NewsProject.dto.PublisherDto
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.*

@Service
class PublisherServiceImpl(
    private val publisherRepository: PublisherRepository,
    private val passwordEncoder: PasswordEncoder
): PublisherService {
    override fun findById(uuid: UUID): PublisherEntity {
        val publisherOptional = publisherRepository.findById(uuid)

        val publisher = if (publisherOptional.isPresent){
            publisherOptional.get()
        } else {
            throw BadRequestException("Publisher not found")
        }
        return publisher
		
		override fun addPublisher(publisher: PublisherDto) {
        val publisherEntity = PublisherEntity().apply {
            this.name = publisher.name
            this.password = passwordEncoder.encode(publisher.password)
            this.email = publisher.email
            this.legalName = publisher.legalName
            this.legalAddress = publisher.legalAddress
            this.accountType = AccountTypes.PUBLISHER
        }
        publisherRepository.save(publisherEntity)
    }
}