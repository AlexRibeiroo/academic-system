package com.example.academicSystem.domain.enrollment;


import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class EnrollmentId {

    //@Column(name = "class_id")
    private UUID classId;
    //@Column(name = "student_id")
    private UUID studentId;

    public EnrollmentId() {
    }

    public EnrollmentId(UUID classId, UUID studantId) {
        this.classId = classId;
        this.studentId = studantId;
    }

    public UUID getClassId() {
        return classId;
    }

    public void setClassId(UUID classId) {
        this.classId = classId;
    }

    public UUID getStudantId() {
        return studentId;
    }

    public void setStudantId(UUID studantId) {
        this.studentId = studantId;
    }

}
