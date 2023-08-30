package ru.ddc.headhunter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Salary{
    public int from;
    @JsonProperty("to")
    public int myto;
    public String currency;
    public boolean gross;
}