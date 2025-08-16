package com.example.NewsProject.response

import com.example.NewsProject.entity.PublisherEntity
import com.example.NewsProject.utils.UUIDSerializer
import io.swagger.v3.oas.annotations.media.Schema
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class PublisherResponse (
    @Serializable(with = UUIDSerializer::class)
    @Schema(description = "UUID издателя")
    val uuid: UUID,
    @Schema(description = "Ник издателя")
    val name: String,
    @Schema(description = "Электронная почта издателя")
    val email: String,
    @Schema(description = "Юридическое название компании")
    val legalName: String,
    @Schema(description = "Юридический адрес компании")
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