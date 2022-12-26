package com.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dateOfBirth;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    @Column(columnDefinition = "int default 1")
    private int deleteStatus = 1;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position positionId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division divisionId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegreeId;


    @OneToMany(mappedBy = "employeeId")
    @JsonBackReference
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, String idCard, double salary, String phoneNumber, String email, String address, int deleteStatus, Position positionId, Division divisionId, EducationDegree educationDegreeId, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.deleteStatus = deleteStatus;
        this.positionId = positionId;
        this.divisionId = divisionId;
        this.educationDegreeId = educationDegreeId;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }


    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}

