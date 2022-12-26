package com.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dateStart;
    private String dateEnd;
    private double deposit;

    @Column(columnDefinition = "int default 1")
    private int deleteStatus = 1;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employeeId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customerId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facilityId;

    @OneToMany(mappedBy = "contractId")
    @JsonBackReference
    private Set<ContractDetail> contractDetailSet;

    public Contract() {
    }

    public Contract(int id, String dateStart, String dateEnd, double deposit, int deleteStatus, Employee employeeId, Customer customerId, Facility facilityId, Set<ContractDetail> contractDetailSet) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.deleteStatus = deleteStatus;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.facilityId = facilityId;
        this.contractDetailSet = contractDetailSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
