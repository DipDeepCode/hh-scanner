package ru.ddc.headhunter.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Salary{
    private int from;
    @JsonProperty("to")
    private int myto;
    private String currency;
    private boolean gross;
}