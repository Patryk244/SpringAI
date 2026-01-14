package com.project.springAi.Service;

import com.project.springAi.Tool.DataTimeTools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeminiService {


    private final ChatModel chatModel;
    private ToolCallback toolCallback;

    public String askQuestionToGemini(String prompt) {
        return ChatClient.create(chatModel)
                .prompt(prompt)
                .call()
                .content();
    }

    public String whatDayIsTomorrow() {
        return ChatClient.create(chatModel)
                .prompt("What day is tomorrow")
                .tools(new DataTimeTools())
                .call()
                .content();
    }

    public void setAlarm() {
        log.info("Set alarm");
        /*
        ChatClient.create(chatModel)
                .prompt("Can you set an alarm 10 minutes from now?")
                .tools(dataTimeTools)
                .call()
                .content();

         */
    }
}
