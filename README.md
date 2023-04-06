# ChatGPT4J
ChatGPT Java SDK. Official OpenAI API.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.aminovmaksim/chatgpt4j)](https://maven-badges.herokuapp.com/maven-central/io.github.aminovmaksim/chatgpt4j)
---
### How to install
#### Maven
```xml
<dependency>
    <groupId>io.github.aminovmaksim</groupId>
    <artifactId>chatgpt4j</artifactId>
    <version>1.0.3</version>
</dependency>
```
#### Gradle
```groovy
implementation 'io.github.aminovmaksim:chatgpt4j:1.0.3'
```
---
## How to use
- Initialize the client
```java
ChatGPTClient client = ChatGPTClient.builder()
        .apiKey("YOUR_KEY")
        .requestTimeout(30000L) // optional, default is 60000 ms
        .baseUrl("https://api.openai.com/v1") // optional
        .build();
```
You can get your api key [here](https://platform.openai.com/account/api-keys)

- Send a message
```java
ChatRequest request = new ChatRequest("Write an essay about AI revolution");
request.setModel(ModelType.GPT_3_5_TURBO.getName());

ChatResponse response = client.sendChat(request);
System.out.println(response.getChoices().get(0).getMessage().getContent());
```

---
### GPT-4

Join waitlist [here](https://openai.com/waitlist/gpt-4-api)

---
## Disclaimers
Project currently in develop, feel free to contact me [@aminovmaksim](https://github.com/aminovmaksim)
