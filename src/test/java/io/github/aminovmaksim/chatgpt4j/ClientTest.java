package io.github.aminovmaksim.chatgpt4j;

import io.github.aminovmaksim.chatgpt4j.model.ChatRequest;
import io.github.aminovmaksim.chatgpt4j.model.ChatResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @Ignore
    public void test() {
        ChatGPTClient client = ChatGPTClient.builder()
                .apiKey("API_KEY")
                .requestTimeout(30000L)
                .baseUrl("https://api.openai.com/v1")
                .build();

        logger.info("Start request");

        ChatResponse response = client.sendChat(new ChatRequest("Write an essay about AI revolution"));

        logger.info(response.getChoices().get(0).getMessage().getContent());
    }
}
