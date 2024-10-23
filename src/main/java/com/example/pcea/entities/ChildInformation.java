package com.example.pcea.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "child_information")
public class ChildInformation {

    @Id
    @Column(name = "child_contact", nullable = false, unique = true)
    private String childContact; // Primary key

    @Column(name = "child_name")
    private String childName;

    @Column(name = "year_of_birth")
    private LocalDate yearOfBirth; // Changed from int to LocalDate

    @Column(name = "baptized")
    private String baptized;

    @Column(name = "confirmed")
    private String confirmed;

    @Column(name = "attends_church_school")
    private String attendsChurchSchool;
}
