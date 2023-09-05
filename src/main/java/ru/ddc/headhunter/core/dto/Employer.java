package ru.ddc.headhunter.core.dto;

import lombok.Data;

@Data
public class Employer{
    private String id;
    private String name;
    private String url;
    private String alternate_url;
    private LogoUrls logo_urls;
    private String vacancies_url;
    private boolean accredited_it_employer;
    private boolean trusted;
}