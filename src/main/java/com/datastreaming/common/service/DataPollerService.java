package com.datastreaming.common.service;

import com.datastreaming.users.dto.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/** Author: Mohammed Anas Date: 04/04/2025 */

@Service
@Slf4j
public class DataPollerService {

    private static final String API_URL = "https://randomuser.me/api/?results=1000";

    private final RestTemplate restTemplate;
    private final KafkaProducerService kafkaProducerService;

    public DataPollerService(RestTemplate restTemplate, KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 60000)
    public void fetchUsers() {
        String data = restTemplate.getForObject(API_URL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Deserialize the JSON string into the UserResponse object
//             UserResponse userResponse = objectMapper.readValue(data, UserResponse.class);
//            userResponse.getResults().stream().forEach(user -> kafkaProducerService.sendMessage("hello"));
            kafkaProducerService.sendMessage("hello");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
