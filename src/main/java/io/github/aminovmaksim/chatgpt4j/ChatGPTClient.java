package io.github.aminovmaksim.chatgpt4j;

import io.github.aminovmaksim.chatgpt4j.model.ChatRequest;
import io.github.aminovmaksim.chatgpt4j.model.ChatResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ChatGPTClient {

    private static final String OPEN_AI_BASE_URL = "https://api.openai.com/v1";

    private final String apiKey;

    private final OkHttpClient webClient;
    private final ObjectMapper objectMapper;

    private ChatGPTClient(ChatGPTClientBuilder builder) {
        this.apiKey = builder.apiKey;

        this.webClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(builder.webClientTimeout, TimeUnit.MILLISECONDS)
                .build();

        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static ChatGPTClientBuilder builder() {
        return new ChatGPTClientBuilder();
    }

    public ChatResponse sendChat(ChatRequest chatRequest) {
        String authHeader = "Bearer " + apiKey;

        try {
            RequestBody body = RequestBody.create(objectMapper.writeValueAsBytes(chatRequest));
            Request request = new Request.Builder()
                    .url(OPEN_AI_BASE_URL + "/chat/completions")
                    .method("POST", body)
                    .addHeader("Authorization", authHeader)
                    .addHeader("Content-Type", "application/json")
                    .build();
            String responseBody = Objects.requireNonNull(webClient.newCall(request).execute().body()).string();
            ChatResponse chatResponse = objectMapper.readValue(responseBody, ChatResponse.class);

            if (chatResponse.getError() != null) {
                throw new RuntimeException(chatResponse.getError().getMessage());
            }

            return chatResponse;
        } catch (Exception e) {
            throw new ChatGPTClientException(e.getMessage());
        }
    }

    @NoArgsConstructor
    public static class ChatGPTClientBuilder {

        private String apiKey;
        private Long webClientTimeout = 60000L;

        /**
         * @param apiKey OpenAI api key
         */
        public ChatGPTClientBuilder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * @param timeout connection timeout in milliseconds, default = 60000
         */
        public ChatGPTClientBuilder requestTimeout(Long timeout) {
            this.webClientTimeout = timeout;
            return this;
        }

        public ChatGPTClient build() {
            return new ChatGPTClient(this);
        }
    }
}
