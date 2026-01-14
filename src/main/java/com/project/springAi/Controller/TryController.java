package com.project.springAi.Controller;

import com.project.springAi.Tool.DataTimeTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v2/")
@RestController
public class TryController {

    private final ChatClient chatClient;

    public TryController(ChatClient.Builder bulider) {
        this.chatClient = bulider.build();
    }

    @GetMapping("ask")
    public String askQuestionToGemini() {
        log.info("askQuestionToGemini");
        return chatClient.prompt("What day is tomorrow")
                .tools(new DataTimeTools())
                .call()
                .content();
    }
}
