package com.careconnectapi.api.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "asutosh_appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentID", nullable = false)
    private int appointmentId;

    @Column(name = "patientID", nullable = false)
    private int patientId;

    @Column(name = "doctorID", nullable = false)
    private int doctorId;

    @Column(name = "AppointmentDate", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "AppointmentTime", nullable = false)
    private LocalTime appointmentTime;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "ReasonForVisit", nullable = false)
    private String reasonForVisit;

    @Column(name = "CreatedAt", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;
    
//    @Column(name = "AppointmentState", nullable = false)
//    private String appointmentState;

    // Getters and Setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
//    public String getState() {
//        return appointmentState;
//    }
//
//    public void setState(String appointmentState) {
//        this.appointmentState = appointmentState;
//    }
}