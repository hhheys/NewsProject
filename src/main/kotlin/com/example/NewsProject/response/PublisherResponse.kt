package com.example.NewsProject.response

import com.example.NewsProject.entity.PublisherEntity
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class PublisherResponse (
    val uuid: UUID,
    val name: String,
    val legalName: String,
    val legalAddress: String
) {
    constructor(publisherEntity: PublisherEntity): this(
        uuid = publisherEntity.id ?: UUID.fromString("0"),
        name = publisherEntity.name ?: "",
        legalName = publisherEntity.legalName ?: "",
        legalAddress = publisherEntity.legalAddress ?: ""
    )
}