package ru.ddc.headhunter.core.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.ddc.headhunter.core.dto.Items;

import java.time.LocalDateTime;

@Service
public class HeadHunterService {

    private final WebClient webClient;

    public HeadHunterService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Items getItems(final LocalDateTime dateTime) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/vacancies")
                        .queryParam("text", "java")
                        .queryParam("date_from", "{datetime}")
                        .build(dateTime))
                .retrieve()
                .bodyToMono(Items.class)
                .block();
    }
}
