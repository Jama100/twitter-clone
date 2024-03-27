package com.cst877.orgaccst8277ahmedjama.UMS.Model;

import jakarta.persistence.*;


import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users") // Ensure this matches your database table name
public class User {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name") // This matches the column in your database
    private String name;

    private String password;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_has_roles",
            joinColumns = @JoinColumn(name = "users_id"), // Make sure this matches your join column name
            inverseJoinColumns = @JoinColumn(name = "roles_id") // And this as well
    )
    private Set<Role> roles;

    // Constructors, Getters, and Setters

    public User() {
    }

    public User(UUID id, String name, String password, String email, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    // Standard getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() { // Note the change here from getUsername to getName
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
