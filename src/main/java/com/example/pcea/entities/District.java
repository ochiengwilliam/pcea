package com.example.pcea.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "District", schema = "dbo")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DistrictName", nullable = false)
    private String districtName;

    @Column(name = "ElderZP")
    private String elderZP;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "UpdatedBy")
    private String updatedBy;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getElderZP() {
        return elderZP;
    }

    public void setElderZP(String elderZP) {
        this.elderZP = elderZP;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
