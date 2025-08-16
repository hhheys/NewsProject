package com.example.NewsProject.service.redis

import org.springframework.data.redis.connection.stream.*
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisService(
    private val redisTemplate: RedisTemplate<String, String>,
) {
    fun sendMessage(streamKey: String, message: Map<String, String>) {
        val record = MapRecord.create(streamKey, message)
        redisTemplate.opsForStream<String, String>().add(record)
    }

    fun readMessages(streamKey: String, consumerGroup: String): List<MapRecord<String, String, String>>?{
        val records = redisTemplate.opsForStream<String, String>()
            .read(
                Consumer.from(consumerGroup, "consumer"),
                StreamOffset.create(streamKey, ReadOffset.lastConsumed())
            )

        return records
    }
}

