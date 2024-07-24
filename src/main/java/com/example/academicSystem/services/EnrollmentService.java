package com.example.academicSystem.services;

import com.example.academicSystem.domain.enrollment.Enrollment;
import com.example.academicSystem.domain.enrollment.EnrollmentId;
import com.example.academicSystem.domain.enrollment.EnrollmentRecordDto;
import com.example.academicSystem.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment createEnrollment (EnrollmentRecordDto data){
        EnrollmentId enrollmentId = new EnrollmentId(
                data.classId(),
                data.studentId()
        );
        Enrollment enrollment = new Enrollment(
                enrollmentId,
                data.enrollmentDate(),
                data.installments()
        );
        return enrollmentRepository.save(enrollment);

    }
    public List<EnrollmentRecordDto> findEnrollments(){
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream().map(enrollment -> new EnrollmentRecordDto(
                enrollment.getInstallments(),
                enrollment.getEnrollmentDate(),
                enrollment.getId().getClassId(),
                enrollment.getId().getStudantId()
        )).toList();
    }

    public EnrollmentRecordDto findEnrollmentById(UUID classId, UUID studentId){
        EnrollmentId enrollmentId = new EnrollmentId(classId, studentId);
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("Enrollment not found!"));
        return new EnrollmentRecordDto(
                enrollment.getInstallments(),
                enrollment.getEnrollmentDate(),
                enrollment.getId().getClassId(),
                enrollment.getId().getStudantId()
        );
    }

}
