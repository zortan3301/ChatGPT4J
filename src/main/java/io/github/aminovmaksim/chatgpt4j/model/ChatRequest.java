package io.github.aminovmaksim.chatgpt4j.model;

import io.github.aminovmaksim.chatgpt4j.model.enums.ModelType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatRequest {

    /**
     * ID of the model to use. Currently, only gpt-3.5-turbo and gpt-3.5-turbo-0301 are supported.
     */
    private String model = ModelType.GPT_3_5_TURBO.getName();

    /**
     * The messages to generate chat completions for
     */
    private List<ChatMessage> messages;

    /**
     * What sampling temperature to use, between 0 and 2. Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     */
    private Float temperature;

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.
     */
    private Float top_p;

    /**
     * How many chat completion choices to generate for each input message.
     */
    private Integer n;

    /**
     * The maximum number of tokens allowed for the generated answer. By default, the number of tokens the model can return will be (4096 - prompt tokens).
     */
    private Integer max_tokens;

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on whether they appear in the text so far, increasing the model's likelihood to talk about new topics.
     */
    private Float presence_penalty;

    /**
     * Number between -2.0 and 2.0. Positive values penalize new tokens based on their existing frequency in the text so far, decreasing the model's likelihood to repeat the same line verbatim.
     */
    private Float frequency_penalty;

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
     */
    private String user;

    public ChatRequest(ChatMessage chatMessage) {
        this.messages = Collections.singletonList(chatMessage);
    }

    public ChatRequest(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public ChatRequest(String message) {
        this.messages = Collections.singletonList(new ChatMessage(message));
    }

}
