package ru.ddc.headhunter.core.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.ddc.headhunter.core.dto.Items;
import ru.ddc.headhunter.telegrambot.service.BotService;

import java.util.Map;

@Slf4j
@Service
public class TelegramNotificationService implements NotificationService {
    private final BotService botService;
    private final ObjectMapper objectMapper;

    @Value("${telegram.message-pattern}")
    private String pattern;


    public TelegramNotificationService(BotService botService, ObjectMapper objectMapper) {
        this.botService = botService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendNotification(@NotNull Items items) {
        if (!items.getItems().isEmpty()) {
            log.info("Найдено {} новых вакансий", items.getItems().size());
            items.getItems().forEach(item -> {
                Map<String, Object> itemMap = objectMapper.convertValue(item, new TypeReference<>() {
                });
                String notification = StringSubstitutor.replace(pattern, itemMap, "&{", "}");
                botService.sendHtmlNotification(notification);
            });
        } else {
            log.info("Новых вакансий не найдено");
            botService.sendPlainNotification("Новых вакансий не найдено");
        }
    }
}
