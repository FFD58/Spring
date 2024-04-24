package ru.fafurin.lesson6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
    private Date created;

    // Пока эти поля игнорируем
    // TODO Создать сущности
    @JsonIgnore
    // Origin origin
        // Integer id
        // String name
        // String url
    private String origin;
    @JsonIgnore
    // Location location
        // Integer id
        // String name
        // String url
    private String location;
    @JsonIgnore
    // Episode episode
        // Integer id
        // String name
        // String airDate
        // String number
        // String url
        // Date created
    private String episode;
}
