package ru.ddc.headhunter.entity;

import lombok.Data;

@Data
public class Metro{
    public String station_name;
    public String line_name;
    public String station_id;
    public String line_id;
    public double lat;
    public double lng;
}