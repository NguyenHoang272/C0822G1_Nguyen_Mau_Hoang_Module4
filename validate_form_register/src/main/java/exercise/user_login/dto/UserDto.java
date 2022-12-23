package exercise.user_login.dto;

import org.hibernate.annotations.Parent;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.*;

public class UserDto {
    private Integer id;


    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 5, max = 45, message = "Size of first name 5 to 45")
    private String firstName;

    @NotEmpty(message = "{NotEmpty}")
    @Size(min = 5, max = 45, message = "Size of first name 5 to 45")
    private String lastName;

    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^[0-9]{9}$", message = "Phone number must have 9 digits")
    private String phoneNumber;

    @NotEmpty(message = "{NotEmpty}")
    @Min(value = 18, message = "Age must be over 19")
    private Integer age;

    @NotEmpty(message = "{NotEmpty}")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email is incorrect format")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
