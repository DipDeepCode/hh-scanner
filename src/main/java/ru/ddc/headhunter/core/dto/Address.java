package ru.ddc.headhunter.core.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Address{
    private String city;
    private String street;
    private String building;
    private double lat;
    private double lng;
    private Object description;
    private String raw;
    private Metro metro;
    private ArrayList<MetroStation> metro_stations;
    private String id;
}