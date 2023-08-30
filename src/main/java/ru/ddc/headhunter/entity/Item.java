package ru.ddc.headhunter.entity;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@Data
@ToString
public class Item{
    public String id;
    public boolean premium;
    public String name;
    public Department department;
    public boolean has_test;
    public boolean response_letter_required;
    public Area area;
    public Salary salary;
    public Type type;
    public Address address;
    public Object response_url;
    public Object sort_point_distance;
    public Date published_at;
    public Date created_at;
    public boolean archived;
    public String apply_alternate_url;
    public Object insider_interview;
    public String url;
    public String alternate_url;
    public ArrayList<Object> relations;
    public Employer employer;
    public Snippet snippet;
    public Object contacts;
    public Object schedule;
    public ArrayList<Object> working_days;
    public ArrayList<Object> working_time_intervals;
    public ArrayList<Object> working_time_modes;
    public boolean accept_temporary;
    public ArrayList<ProfessionalRole> professional_roles;
    public boolean accept_incomplete_resumes;
    public Experience experience;
    public Employment employment;
    public Object adv_response_url;
    public boolean is_adv_vacancy;
    public Branding branding;
    public boolean show_logo_in_search;
}