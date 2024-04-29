package ru.fafurin.lesson6.model;

import lombok.Data;

@Data
public class LocationResponse {
    private Integer id;
    private String name;
    private String type;
    private String dimension;
    private String[] residents;
    private String url;
    private String created;
}
