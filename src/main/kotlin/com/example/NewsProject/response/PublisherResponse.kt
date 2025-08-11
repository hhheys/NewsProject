package com.example.NewsProject.response

import com.example.NewsProject.entity.PublisherEntity
import com.example.NewsProject.utils.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class PublisherResponse (
    @Serializable(with = UUIDSerializer::class)
    val uuid: UUID,
    val name: String,
    val email: String,
    val legalName: String,
    val legalAddress: String
) {
    constructor(publisherEntity: PublisherEntity): this(
        uuid = publisherEntity.id ?: UUID.fromString("0"),
        name = publisherEntity.name ?: "",
        email = publisherEntity.email ?: "",
        legalName = publisherEntity.legalName ?: "",
        legalAddress = publisherEntity.legalAddress ?: ""
    )
}