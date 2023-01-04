package com.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;


    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contractId;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id")
    private AttachFacility attachFacilityId;

    public ContractDetail() {
    }

    public ContractDetail(int id, int quantity, Contract contractId, AttachFacility attachFacilityId) {
        this.id = id;
        this.quantity = quantity;
        this.contractId = contractId;
        this.attachFacilityId = attachFacilityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachFacility getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(AttachFacility attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }
}
