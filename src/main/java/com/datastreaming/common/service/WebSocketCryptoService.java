package com.datastreaming.common.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

/** Author: Mohammed Anas Date: 14/04/2025 */

@Service
@Slf4j
public class WebSocketCryptoService {


    private final KafkaProducerService kafkaProducerService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${crypto.ws-url}")
    private String wsUrl;

    @Value("${crypto.topic}")
    private String topic;

    public  WebSocketCryptoService( KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostConstruct
    public void startStreaming() {

    HttpClient.newHttpClient()
        .newWebSocketBuilder()
        .buildAsync(
            URI.create(wsUrl),
            new WebSocket.Listener() {
              @Override
              public CompletionStage<?> onText(
                  WebSocket webSocket, CharSequence data, boolean last) {
                try {
                  System.out.println(data);
                  JsonNode json = objectMapper.readTree(data.toString());

                  String base = json.has("base") ? json.get("base").asText() : "N/A";
                  String quote = json.has("quote") ? json.get("quote").asText() : "N/A";
                  String price = json.has("priceUsd") ? json.get("priceUsd").asText() : "0";

                  System.out.printf("[KAFKA] %s/%s: $%s%n", base, quote, price);
                  kafkaProducerService.sendMessage(topic, data.toString());

                } catch (Exception e) {
                  System.err.println("Error parsing JSON message:");
                  e.printStackTrace();
                }

                return WebSocket.Listener.super.onText(webSocket, data, last);
              }

              @Override
              public void onError(WebSocket webSocket, Throwable error) {
                System.err.println("WebSocket error: " + error.getMessage());
                WebSocket.Listener.super.onError(webSocket, error);
              }
            })
        .join();
    }

}
