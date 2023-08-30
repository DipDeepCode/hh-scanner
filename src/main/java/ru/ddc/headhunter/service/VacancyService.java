package ru.ddc.headhunter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.ddc.headhunter.entity.Vacancies;

import java.time.LocalDateTime;

@Service
public class VacancyService {

    private final WebClient webClient;

    public VacancyService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Vacancies getVacancyByIdSync(final LocalDateTime dateTime) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/vacancies")
                        .queryParam("text", "java")
                        .queryParam("date_from", "{datetime}")
                        .build(dateTime))
                .retrieve()
                .bodyToMono(Vacancies.class)
                .block();
    }
}
