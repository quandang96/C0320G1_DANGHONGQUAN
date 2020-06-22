package com.validate_form.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank
    @Size(min = 5,max = 45 )
    private String firstName;

    @Column(name="last_name")
    @Size(min = 5,max = 45)
    @NotBlank
    private String lastName;

    @Column(name = "phone_number")
    @Pattern(regexp = "(^0[0-9]{9})",message ="Enter the wrong phone number" )
    @NotBlank
    private String phoneNumber;

    @Pattern(regexp = "((\\w+([.]\\w+)*)[@][\\w]+(\\.[a-z]+){1,2})",message ="Enter the wrong Email" )
    @NotBlank
    private String email;

    @Min(value = 18,message = "error")
    private int age;
    @Size(min = 5, max = 45)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Long id, String firstName, String lastName, String phoneNumber, String email, int age, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.password = password;
    }



    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
