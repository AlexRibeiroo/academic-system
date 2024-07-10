package com.example.academicSystem.domain.enrollment;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="enrollments")
public class Enrollment {
    @EmbeddedId
    private EnrollmentId enrollmentId;

//    @ManyToOne
//    @MapsId
//    @JoinColumn(name = "group_id")
//    private Group group;
//
//    @ManyToOne
//    @MapsId
//    @JoinColumn(name = "student_id")
//    private Student student;

    private LocalDate enrollmentDate;
    private Integer installments;

    public Enrollment() {
    }

    public Enrollment(EnrollmentId enrollmentId, LocalDate enrollmentDate, Integer installments) {
        this.enrollmentId = enrollmentId;

        this.enrollmentDate = enrollmentDate;
        this.installments = installments;
    }

    public EnrollmentId getId() {
        return enrollmentId;
    }


    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
