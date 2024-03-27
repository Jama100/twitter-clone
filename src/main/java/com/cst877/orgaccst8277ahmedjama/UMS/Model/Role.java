package com.cst877.orgaccst8277ahmedjama.UMS.Model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity // This annotation marks the class as a JPA entity
@Table (name = "roles")
public class Role {
    @Id // This marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This strategy is for auto-incremented columns
    private UUID id;
    private String name;

    // Constructors, Getters, and Setters
    public Role() {
    }

    public Role(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
