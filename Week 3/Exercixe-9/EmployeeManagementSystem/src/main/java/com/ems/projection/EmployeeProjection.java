package com.ems.projection;

public class EmployeeProjection {
    private Integer id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeProjection(Integer id, String name, String email, String deptName){
        this.id = id;
        this.name = name;
        this.email= email;
        this.departmentName = deptName;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
}
