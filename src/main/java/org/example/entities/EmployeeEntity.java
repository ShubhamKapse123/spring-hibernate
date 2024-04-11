package org.example.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "employee_details")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;
    @Column(name = "emp_name")
    private String eName;
    @Column(name = "emp_job")
    private String jobDetails;
    @Column(name = "emp_managerid")
    private int mangerId;
    @Column(name = "emp_hiredate")
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Column(name = "emp_deptid")
    private int departmentId;
    @Column(name = "emp_salary")
    private double salary;

    public EmployeeEntity() {
        super();
    }

    public EmployeeEntity(String empId, String eName, String jobDetails, int mangerId, Date joinDate, int departmentId, double salary) {
        empId = empId;
        this.eName = eName;
        this.jobDetails = jobDetails;
        this.mangerId = mangerId;
        this.joinDate = joinDate;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Long getEmpId() {
        return empId;
    }

    public String geteName() {
        return eName;
    }

    public String getJobDetails() {
        return jobDetails;
    }

    public int getMangerId() {
        return mangerId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmpId(String empId) {
        empId = empId;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }

    public void setMangerId(int mangerId) {
        this.mangerId = mangerId;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
