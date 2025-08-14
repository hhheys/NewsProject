package com.example.NewsProject.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.apache.kafka.common.serialization.Serializer

class KotlinxJsonSerializer<T> (
    private val serializer: KSerializer<T>
) : Serializer<T> {
    override fun serialize(topic: String?, data: T?): ByteArray? {
        if (data == null) return null
        return Json.encodeToString(serializer, data).toByteArray(Charsets.UTF_8)
    }
}