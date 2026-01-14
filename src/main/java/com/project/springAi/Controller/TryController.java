package com.project.springAi.Controller;

import com.project.springAi.Tool.DataTimeTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.model.ChatModel;


@Slf4j
@RequestMapping("/v2/")
@RestController
public class TryController {

    private final ChatClient chatClient;
    private final ChatModel chatModel;

    public TryController(ChatClient.Builder bulider,  ChatModel chatModel) {
        this.chatClient = bulider.build();
        this.chatModel = chatModel;
    }

    @GetMapping("ask")
    public String askQuestionToGemini() {
        log.info("askQuestionToGemini");
        return chatClient.prompt("What day is tomorrow")
                .tools(new DataTimeTools())
                .call()
                .content();
    }

    @GetMapping("/check")
    public void askSetAlarm() {
        log.info("Learn Programing");
        String res = ChatClient.create(chatModel)
                .prompt("I don't want to code why?")
                .tools(new DataTimeTools())
                .call()
                .content();
        System.out.println(res);
    }
}
