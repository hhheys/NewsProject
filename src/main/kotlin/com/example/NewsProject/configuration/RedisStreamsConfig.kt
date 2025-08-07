package com.example.NewsProject.configuration

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisStreamsConfig(
    private val redisTemplate: RedisTemplate<String, String>
) {
    @PostConstruct
    fun createConsumerGroups(){
        createConsumerGroupIfNotExist("views", "views-group")
        createConsumerGroupIfNotExist("reactions", "reactions-group")
    }

    private fun createConsumerGroupIfNotExist(streamName: String, groupName: String){
        try {
            redisTemplate.opsForStream<String, String>().createGroup(streamName, groupName)
        } catch (e: Exception) {
            println("Group $groupName already exists.")
        }
    }
}