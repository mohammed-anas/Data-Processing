package com.datastreaming.common.service;
import com.datastreaming.users.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/** Author: Mohammed Anas Date: 04/04/2025 */

@Service
public class KafkaProducerService<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    // Constructor with generic type
    public KafkaProducerService(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Generic method to send a message
    public void sendMessage(T dto) {
        kafkaTemplate.send(topicName, dto);
        System.out.println("Message sent to topic '" + topicName + "': " + dto);
    }
}