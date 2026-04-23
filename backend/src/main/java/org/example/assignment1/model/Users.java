package org.example.assignment1.model;

// Author: Syed Rayan Hashmi (ID: 764000072)
// Entity: Users

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name = "Default User";

    @Column(unique = true, nullable = false)
    private String email = "user@example.com";

    private String role = "attendee"; // "attendee" or "admin"

    public Users() {}

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "Users{id=" + id + ", name='" + name + "', email='" + email + "', role='" + role + "'}";
    }
}
