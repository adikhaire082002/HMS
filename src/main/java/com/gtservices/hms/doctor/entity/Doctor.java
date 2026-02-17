package com.gtservices.hms.doctor.entity;

import com.gtservices.hms.appointment.entity.Appointment;
import com.gtservices.hms.consultation.entity.Consultation;
import com.gtservices.hms.enums.Gender;

import com.gtservices.hms.user.entity.User;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "doctor_uid", unique = true, length = 20)
    private String doctorUid;

    @Column(name = "doctor_name", length = 100)
    private String doctorName;

    @Column(name = "guardian_name", length = 100)
    private String guardianName;

    @Column(name = "contact_no", unique = true, length = 15)
    private String contactNo;

    @Column(name = "email_id", unique = true, length = 100)
    private String emailId;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @Column(name = "consultation_fees", precision = 10, scale = 2)
    private BigDecimal consultationFees;

    @Column(name = "has_experience")
    private Boolean hasExperience;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorEducation> educations;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorExperience> experiences;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorAvailability> availabilities;

    @OneToOne
    @JoinColumn(name = "user_id" , nullable = false , unique = true)
    private User user;

}