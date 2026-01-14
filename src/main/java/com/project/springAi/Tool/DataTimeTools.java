package com.project.springAi.Tool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Slf4j
@Component
public class DataTimeTools {

    @Tool(description = "What day is today")
    String getCurrentDateTime() {
        log.info("What day is today from tools");
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

    @Tool(description = "Why people don't want to learn programing")
    String getLearnReason() {
        log.info("Learn from tools");
        return "These people a little time.";
    }
}
