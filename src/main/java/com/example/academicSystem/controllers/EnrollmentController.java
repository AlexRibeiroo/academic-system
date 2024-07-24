package com.example.academicSystem.controllers;

import com.example.academicSystem.domain.enrollment.Enrollment;
import com.example.academicSystem.domain.enrollment.EnrollmentRecordDto;
import com.example.academicSystem.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private  EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody EnrollmentRecordDto enrollmentRecordDto){
        Enrollment enrollment = enrollmentService.createEnrollment(enrollmentRecordDto);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentRecordDto>> getEnrollments(){
        return ResponseEntity.ok(enrollmentService.findEnrollments());
    }

    @GetMapping("/{classId}/{studentId}")
    public ResponseEntity<EnrollmentRecordDto> getEnrollmentById(@PathVariable UUID classId, @PathVariable UUID studentId){
        return ResponseEntity.ok(enrollmentService.findEnrollmentById(classId, studentId));
    }
}
