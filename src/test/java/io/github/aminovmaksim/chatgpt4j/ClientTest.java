package io.github.aminovmaksim.chatgpt4j;

import io.github.aminovmaksim.chatgpt4j.model.ChatRequest;
import io.github.aminovmaksim.chatgpt4j.model.ChatResponse;
import org.junit.Ignore;
import org.junit.Test;

public class ClientTest {

    @Test
    @Ignore
    public void test() {
        ChatGPTClient client = ChatGPTClient.builder()
                .apiKey("YOUR_KEY")
                .build();

        ChatResponse response = client.sendChat(new ChatRequest("Hello"));

        System.out.println(response.getChoices().get(0).getMessage().getContent());
    }
}
