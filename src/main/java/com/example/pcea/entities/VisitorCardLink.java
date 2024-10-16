package com.example.pcea.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Visitor_Card_Link")
public class VisitorCardLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Phone_No", nullable = false)

    private String phoneNo;

    @Column(name = "Card_Serial_No", nullable = false)
    private String cardSerialNo;

    @Column(name = "Card_Link_Status", nullable = false)

    private String cardLinkStatus;

    @Column(name = "Assigned_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedDate;

    @Column(name = "De_Assigned_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deAssignedDate;

    @Column(name = "Issues", columnDefinition = "TEXT")
    private String issues;


    public VisitorCardLink() {
    }

    public VisitorCardLink(String phoneNo, String cardSerialNo, String cardLinkStatus, Date assignedDate, Date deAssignedDate, String issues) {
        this.phoneNo = phoneNo;
        this.cardSerialNo = cardSerialNo;
        this.cardLinkStatus = cardLinkStatus;
        this.assignedDate = assignedDate;
        this.deAssignedDate = deAssignedDate;
        this.issues = issues;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCardSerialNo() {
        return cardSerialNo;
    }

    public void setCardSerialNo(String cardSerialNo) {
        this.cardSerialNo = cardSerialNo;
    }

    public String getCardLinkStatus() {
        return cardLinkStatus;
    }

    public void setCardLinkStatus(String cardLinkStatus) {
        this.cardLinkStatus = cardLinkStatus;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getDeAssignedDate() {
        return deAssignedDate;
    }

    public void setDeAssignedDate(Date deAssignedDate) {
        this.deAssignedDate = deAssignedDate;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }


    @Override
    public String toString() {
        return "VisitorCardLink{" +
                "id=" + id +
                ", phoneNo='" + phoneNo + '\'' +
                ", cardSerialNo='" + cardSerialNo + '\'' +
                ", cardLinkStatus='" + cardLinkStatus + '\'' +
                ", assignedDate=" + assignedDate +
                ", deAssignedDate=" + deAssignedDate +
                ", issues='" + issues + '\'' +
                '}';
    }
}