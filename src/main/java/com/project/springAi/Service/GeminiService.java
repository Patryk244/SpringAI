package com.project.springAi.Service;

import com.project.springAi.Tool.DataTimeTools;
import lombok.RequiredArgsConstructor;
import org.apache.el.util.ReflectionUtil;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.definition.ToolDefinition;
import org.springframework.ai.tool.method.MethodToolCallback;
import org.springframework.ai.tool.support.ToolDefinitions;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final ChatModel chatModel;

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

    public String setAlarm() {
        return ChatClient.create(chatModel)
                .prompt("Can you set an alarm 10 minutes from now?")
                .tools(new DataTimeTools())
                .call()
                .content();
    }
}
