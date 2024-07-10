package com.example.academicSystem.domain.result;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ResultId {

    private UUID studentId;
    private UUID assessmentId;

    public ResultId() {
    }

    public ResultId(UUID studentId, UUID assessmentId) {
        this.studentId = studentId;
        this.assessmentId = assessmentId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(UUID assessmentId) {
        this.assessmentId = assessmentId;
    }
}
