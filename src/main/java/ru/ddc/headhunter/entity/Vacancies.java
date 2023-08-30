package ru.ddc.headhunter.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Vacancies {
    List<Item> items = new ArrayList<>();
}
