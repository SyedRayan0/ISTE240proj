package org.example.assignment1.model;

// Author: Ali Faisal (ID: 415002117)
// Entity: Administrator

import jakarta.persistence.*;

@Entity
@Table(name = "administrators")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String adminId = "ADM-001";

    private String accessLevel = "Full";

    private String department = "Operations";

    public Administrator() {}

    public Administrator(String adminId, String accessLevel, String department) {
        this.adminId = adminId;
        this.accessLevel = accessLevel;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }

    public String getAccessLevel() { return accessLevel; }
    public void setAccessLevel(String accessLevel) { this.accessLevel = accessLevel; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "Administrator{id=" + id + ", adminId='" + adminId + "', department='" + department + "'}";
    }
}
