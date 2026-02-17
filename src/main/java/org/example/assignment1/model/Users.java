package org.example.assignment1.model;

import org.springframework.stereotype.Component;

@Component
public class Users {
    private String name = "Default User";
    private String email = "user@example.com";
    private String role = "attendee"; // "attendee" or "admin"


    public Users() {}


    public String getName() { return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
