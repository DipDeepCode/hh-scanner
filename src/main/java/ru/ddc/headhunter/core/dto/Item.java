package ru.ddc.headhunter.core.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@Data
@ToString
public class Item{
    private String id;
    private boolean premium;
    private String name;
    private Department department;
    private boolean has_test;
    private boolean response_letter_required;
    private Area area;
    private Salary salary;
    private Type type;
    private Address address;
    private Object response_url;
    private Object sort_point_distance;
    private Date published_at;
    private Date created_at;
    private boolean archived;
    private String apply_alternate_url;
    private Object insider_interview;
    private String url;
    private String alternate_url;
    private ArrayList<Object> relations;
    private Employer employer;
    private Snippet snippet;
    private Object contacts;
    private Object schedule;
    private ArrayList<Object> working_days;
    private ArrayList<Object> working_time_intervals;
    private ArrayList<Object> working_time_modes;
    private boolean accept_temporary;
    private ArrayList<ProfessionalRole> professional_roles;
    private boolean accept_incomplete_resumes;
    private Experience experience;
    private Employment employment;
    private Object adv_response_url;
    private boolean is_adv_vacancy;
    private Branding branding;
    private boolean show_logo_in_search;
}