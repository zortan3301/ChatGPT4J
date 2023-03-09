package io.github.aminovmaksim.chatgpt4j.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {

    /**
     * Identifier of the response
     */
    private String id;

    /**
     * Type of request
     */
    private String object;

    /**
     * Timestamp in UNIX format
     */
    private Long created;

    /**
     * List of responses
     */
    private List<Choice> choices;

    /**
     * Info about token usage for request
     */
    private Usage usage;

    /**
     * Error info
     */
    private Error error;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice {

        private Integer index;
        private ChatMessage message;
        private String finish_reason;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usage {

        private Integer prompt_tokens;
        private Integer completion_tokens;
        private Integer total_tokens;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Error {

        private String message;
        private String type;
        private String code;
    }
}
