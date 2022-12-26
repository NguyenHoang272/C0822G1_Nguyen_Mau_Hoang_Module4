package com.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "facilityTypeId")
    @JsonBackReference
    private Set<Facility> facilitys;

    public FacilityType() {
    }

    public FacilityType(int id, String name, Set<Facility> facilitys) {
        this.id = id;
        this.name = name;
        this.facilitys = facilitys;
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

    public Set<Facility> getFacilitys() {
        return facilitys;
    }

    public void setFacilitys(Set<Facility> facilitys) {
        this.facilitys = facilitys;
    }
}
