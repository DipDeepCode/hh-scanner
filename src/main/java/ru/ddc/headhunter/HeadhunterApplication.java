package ru.ddc.headhunter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ddc.headhunter.entity.Vacancies;
import ru.ddc.headhunter.service.VacancyService;

import java.time.LocalDateTime;

@SpringBootApplication
public class HeadhunterApplication implements CommandLineRunner {

	private final VacancyService vacancyService;

	public HeadhunterApplication(VacancyService vacancyService) {
		this.vacancyService = vacancyService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HeadhunterApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		Vacancies vacancyByIdSync = vacancyService.getVacancyByIdSync(LocalDateTime.now().minusMinutes(60L));

		vacancyByIdSync.getItems().forEach(item -> {
            System.out.println(item.getName());
            System.out.println(item.getArea() == null ? "" : item.getArea().getName());
			System.out.println(item.getAlternate_url());
			System.out.println(item.getSnippet() == null ? "" : item.getSnippet().getResponsibility());
			System.out.println(item.getSnippet() == null ? "" : item.getSnippet().getRequirement());
        });
		System.out.println("----------------");
	}

}
