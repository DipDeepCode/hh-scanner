package ru.ddc.headhunter.core.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Items {
    private List<Item> items = new ArrayList<>();
}
