package com.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberFloors;
    private String facilityFree;
    @Column(columnDefinition = "int default 1")
    private int deleteStatus = 1;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    private RentType rentTypeId;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "facility_type_id",referencedColumnName = "id")
    private FacilityType facilityTypeId;

    @OneToMany(mappedBy = "facilityId")
    @JsonBackReference
    private Set<Contract> contracts;

    public Facility() {
    }

    public Facility(int id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberFloors, String facilityFree, int deleteStatus, RentType rentTypeId, FacilityType facilityTypeId, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.facilityFree = facilityFree;
        this.deleteStatus = deleteStatus;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public FacilityType getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(FacilityType facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
