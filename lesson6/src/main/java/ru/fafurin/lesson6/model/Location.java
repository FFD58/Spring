package ru.fafurin.lesson6.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "locations")
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String dimension;

    @OneToMany(mappedBy="location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Character> residents = new ArrayList<>();
    private String url;
    private String created;

    public void addResident(Character resident) {
        if (resident != null) {
            residents.add(resident);
        }
        resident.setLocation(this);
    }
}
