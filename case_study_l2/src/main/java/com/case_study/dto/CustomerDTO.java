package com.case_study.dto;

import com.case_study.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotBlank;

public class CustomerDTO implements Validator {
    private int id;

    @NotBlank(message = "Not empty")
    private String name;

    private String dateOfBirth;

    private int gender;
    @NotBlank(message = "Not empty")
    private String idCard;


    @NotBlank(message = "Not empty")
    private String phoneNumber;

    @NotBlank(message = "Not empty")
    private String email;


    @NotBlank(message = "Not empty")
    private String address;
    private int deleteStatus = 1;
    private CustomerType customerTypeId;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, String dateOfBirth, int gender, String idCard, String phoneNumber, String email, String address, int deleteStatus, CustomerType customerTypeId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.deleteStatus = deleteStatus;
        this.customerTypeId = customerTypeId;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        if (!customerDTO.name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("name", "name.errors", "Name not format! Name not number!");
        }
        if (!(customerDTO.getPhoneNumber().matches("[0][9][0]\\d{7}") ||
                customerDTO.getPhoneNumber().matches("[0][9][1]\\d{7}") ||
                customerDTO.getPhoneNumber().matches("[(][8][4][)][+][9][0]\\d{7}") ||
                customerDTO.getPhoneNumber().matches("[(][8][4][)][+][9][1]\\d{7}"))) {
            errors.rejectValue("phoneNumber", "phoneNumber.errors", "Phone not format : 090xxxxxxx or 091xxxxxxx");
        }
        if (!customerDTO.email.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+([A-Za-z0-9]+\\.)+(com)$")) {
            errors.rejectValue("email", "email.errors", "Email not format");
        }
        if (!(customerDTO.getIdCard().matches("\\d{9}") || customerDTO.getIdCard().matches("\\d{12}"))) {
            errors.rejectValue("idCard", "idCard.errors", "IdCard not format! IdCard is 9 or 12 characters");
        }
    }
}
