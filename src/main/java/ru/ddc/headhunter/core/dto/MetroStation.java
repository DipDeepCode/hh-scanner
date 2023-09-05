package ru.ddc.headhunter.core.dto;

import lombok.Data;

@Data
public class MetroStation{
    private String station_name;
    private String line_name;
    private String station_id;
    private String line_id;
    private double lat;
    private double lng;
}