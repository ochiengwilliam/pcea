package com.example.pcea.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @Column(name = "mobile", nullable = false, unique = true) // Primary key
    @NotNull
    private String mobile;

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

    @Column(name = "spouse_zp_no", nullable = true)
    private String spouseZpNo;

    @NotNull
    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalId;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "baptized", nullable = false)
    private String baptized;

}
