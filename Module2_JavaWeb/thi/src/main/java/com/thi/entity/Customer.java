package com.thi.entity;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;

    @Pattern(regexp = "^KH-\\d{4}$", message = "Customer code must be KH-XXXX")
    @Column(name = "customer_code")
    private String code;

    @Size(min = 2, max = 30, message = "The name is too long")
    @Column(name = "customer_name", columnDefinition = "nvarchar(30)")
    private String name;

    @Pattern(regexp = "^\\d{9}$", message = "ID Card format must be 9 number!")
    @Column(name = "customer_idcard")
    private String idCard;

    @Pattern(regexp = "^([0-9]{7}$)", message = "Phone number is wrong format")
    @Column(name = "customer_phonenumber")
    private String phoneNumber;

    @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format")
    @Column(name = "customer_email")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "customer_birthday")
    private LocalDate birthday;


    @Pattern(regexp = "^\\w+$", message = "Invalid address")
    @Column(name = "customer_address")
    private String address;


    @Column(name = "customer_status")
    private boolean status;

    @Column(name = "customer_type")
    private String customerType;

    private String male;

    public Customer() {
    }

    public Customer(long id, @Pattern(regexp = "^KH-\\d{4}$", message = "Customer code must be KH-XXXX") String code, @Size(min = 2, max = 30, message = "The name is too long") String name, @Pattern(regexp = "^\\d{9}$", message = "ID Card format must be 9 number!") String idCard, @Pattern(regexp = "^([0-9]{7}$)", message = "Phone number is wrong format") String phoneNumber, @Pattern(regexp = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$", message = "Email is wrong format") String email, LocalDate birthday, @Pattern(regexp = "^\\w+$", message = "Invalid address") String address, boolean status, String customerType, String male) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.status = status;
        this.customerType = customerType;
        this.male = male;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }
}
