package ru.ddc.headhunter.core.service;

import org.springframework.stereotype.Service;
import ru.ddc.headhunter.core.dto.Items;

@Service
public interface NotificationService {

    void sendNotification(Items items);
}
