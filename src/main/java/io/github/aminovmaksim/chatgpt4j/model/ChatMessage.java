package io.github.aminovmaksim.chatgpt4j.model;

import io.github.aminovmaksim.chatgpt4j.model.enums.MessageRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    private String role = MessageRole.USER.getName();
    private String content;

    public ChatMessage(String content) {
        this.content = content;
    }
}