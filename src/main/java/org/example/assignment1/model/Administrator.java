package org.example.assignment1.model;

import org.springframework.stereotype.Component;

@Component
public class Administrator {

    private String adminId = "ADM-001";
    private String accessLevel = "Full";
    private String department = "Operations";

    // Default Constructor
    public Administrator() {
    }

    // Getters and Setters

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId='" + adminId + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
