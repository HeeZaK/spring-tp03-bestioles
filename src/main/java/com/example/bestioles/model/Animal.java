package com.example.bestioles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String color;

    @Column(nullable = false)
    private String sex;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    // ---- Getters & Setters ----

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }

    @Override
    public String toString() {
        return "Animal{id=" + id + ", name='" + name + "', sex='" + sex
                + "', color='" + color + "', species=" + (species != null ? species.getCommonName() : "null") + "}";
    }
}
