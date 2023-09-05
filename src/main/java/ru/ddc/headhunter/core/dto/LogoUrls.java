package ru.ddc.headhunter.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogoUrls{
    @JsonProperty("240")
    private String _240;
    @JsonProperty("90")
    private String _90;
    private String original;
}