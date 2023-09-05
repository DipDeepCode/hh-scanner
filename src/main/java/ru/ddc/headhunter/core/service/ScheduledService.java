package ru.ddc.headhunter.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.ddc.headhunter.core.dto.Items;

import java.time.LocalDateTime;

@Slf4j
@EnableScheduling
@Service
public class ScheduledService {
    private final HeadHunterService headHunterService;
    private final NotificationService notificationSender;

    @Value("${minus-minutes}")
    int minutes;

    public ScheduledService(HeadHunterService headHunterService,
                            NotificationService notificationSender) {
        this.headHunterService = headHunterService;
        this.notificationSender = notificationSender;
    }

    @Scheduled(cron = "${schedule.cron}")
    public void notifyAboutNewVacancies() {
        Items items = headHunterService.getItems(LocalDateTime.now().minusMinutes(minutes));
        notificationSender.sendNotification(items);
    }
}
