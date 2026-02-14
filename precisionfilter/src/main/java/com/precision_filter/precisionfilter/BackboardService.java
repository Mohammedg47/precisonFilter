package com.precision_filter.precisionfilter;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BackboardService {

    private final WebClient webClient;

    private final String assistantId = "YOUR_REUSABLE_ASSISTANT_ID";

    public BackboardService() { //TODO check all these apis
        this.webClient = WebClient.builder()
                .baseUrl("https://app.backboard.io/api")
                .defaultHeader("X-API-Key", "your_api_key")
                .build();
    }

    public Map<String, Object> analyzeEmail(String emailText) {

        // 🔹 Create a thread (new conversation)
        Map<String, Object> thread = webClient.post()
                .uri("/assistants/" + assistantId + "/threads")
                .bodyValue(Map.of())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();

        String threadId = (String) thread.get("thread_id");


        // 🔹 Send the email text as a message
        Map<String, Object> result = webClient.post()
                .uri("/threads/" + threadId + "/messages")
                .bodyValue(Map.of(
                        "content", emailText,
                        "stream", "true",
                        "memory", "None"
                ))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();

        return result;
    }
}
