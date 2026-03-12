package org.example.assignment1.model;

public class Administrator {
    private String adminId = "ADM-001";
    private String accessLevel = "Full";
    private String department = "Operations";


    public Administrator() {}


    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public String getAccessLevel() { return accessLevel; }
    public void setAccessLevel(String accessLevel) { this.accessLevel = accessLevel; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}