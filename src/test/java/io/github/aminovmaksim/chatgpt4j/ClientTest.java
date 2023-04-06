package io.github.aminovmaksim.chatgpt4j;

import io.github.aminovmaksim.chatgpt4j.model.ChatRequest;
import io.github.aminovmaksim.chatgpt4j.model.ChatResponse;
import io.github.aminovmaksim.chatgpt4j.model.enums.ModelType;
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

        ChatRequest request = new ChatRequest("Write an essay about AI revolution");
        request.setModel(ModelType.GPT_3_5_TURBO.getName());

        ChatResponse response = client.sendChat(request);

        logger.info(response.getChoices().get(0).getMessage().getContent());
    }
}
