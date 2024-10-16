package com.example.pcea.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "district")
    private String district;

    @Column(name = "zp_no")
    private String zpNo;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "spouse_name")
    private String spouseName;

    // spouseZpNo can now accept null or empty values
    @Column(name = "spouse_zp_no", nullable = true)
    private String spouseZpNo;

    @NotNull
    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalId;

    @NotNull
    @Column(name = "mobile", nullable = false)
    private String mobile;

    // Getters and Setters

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZpNo() {
        return zpNo;
    }

    public void setZpNo(String zpNo) {
        this.zpNo = zpNo;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseZpNo() {
        return spouseZpNo;
    }

    public void setSpouseZpNo(String spouseZpNo) {
        this.spouseZpNo = spouseZpNo;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
