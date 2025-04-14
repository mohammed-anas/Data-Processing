package com.datastreaming.common.service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/** Author: Mohammed Anas Date: 04/04/2025 */

@Service
public class KafkaProducerService<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    // Constructor with generic type
    public KafkaProducerService(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Generic method to send a message
    public void sendMessage(String topic ,T dto) {
        kafkaTemplate.send(topic, dto);
        System.out.println("Message sent to topic '" + topic + "': " + dto);
    }
}