package com.project.springAi.Controller;

import com.project.springAi.Service.GeminiService;
import com.project.springAi.Tool.DataTimeTools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.*;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class MyController {

    private final GeminiService geminiService;


    @GetMapping("/ai/1")
    public String test1(@RequestParam("prompt") String prompt) {
        log.info("Request received for /ai/1");
        return geminiService.askQuestionToGemini(prompt);
    }

    @GetMapping("/ai/zone")
    public String test2() {
        log.info("Request received for /ai/zone");
        return geminiService.whatDayIsTomorrow();
    }

    @GetMapping("/set")
    public void test3() {
        log.info("Request received for /set");
        geminiService.setAlarm();
    }
}
