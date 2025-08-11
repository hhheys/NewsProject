package com.example.NewsProject.response

import com.example.NewsProject.entity.UserEntity
import com.example.NewsProject.utils.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UserResponse(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val role: String
) {
    constructor(userEntity: UserEntity): this(
        id = userEntity.id ?: UUID.fromString("0"),
        name = userEntity.name ?: "",
        role = userEntity.role ?: ""
    )
}
