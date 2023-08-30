package ru.ddc.headhunter.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Address{
    public String city;
    public String street;
    public String building;
    public double lat;
    public double lng;
    public Object description;
    public String raw;
    public Metro metro;
    public ArrayList<MetroStation> metro_stations;
    public String id;
}