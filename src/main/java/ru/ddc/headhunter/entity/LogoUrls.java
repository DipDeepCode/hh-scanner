package ru.ddc.headhunter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogoUrls{
    @JsonProperty("240")
    public String _240;
    @JsonProperty("90")
    public String _90;
    public String original;
}