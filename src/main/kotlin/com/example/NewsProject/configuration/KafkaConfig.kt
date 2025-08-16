package com.example.NewsProject.configuration

import com.example.NewsProject.dto.kafka.PostEvent
import com.example.NewsProject.utils.KotlinxJsonSerializer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


@Configuration
class KafkaConfig {

    @Bean
    fun producerFactory(): ProducerFactory<String, PostEvent> {
        val configProps = mapOf<String, Any>(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
//            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
//            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to KotlinxJsonSerializer::class.java
        )
        return DefaultKafkaProducerFactory(
            configProps,
            StringSerializer(),
            KotlinxJsonSerializer(PostEvent.serializer())
        )
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, PostEvent> = KafkaTemplate(producerFactory())
}