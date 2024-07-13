package com.example.academicSystem.controllers;

import com.example.academicSystem.domain.student.Student;
import com.example.academicSystem.domain.student.StudentRecordDto;
import com.example.academicSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRecordDto studentRecordDto){
        return ResponseEntity.ok(studentService.createStudent(studentRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<StudentRecordDto>> getAllStudent(){
        return ResponseEntity.ok(studentService.findStudents());
    }

    @GetMapping("/{idStudent}")
    public ResponseEntity<StudentRecordDto> getStudent(@PathVariable(value="idStudent") UUID idStudent){
        return ResponseEntity.ok(studentService.findStudentById(idStudent));
    }

    @PutMapping("/{idStudent}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value="idStudent") UUID idStudent,
                                                 @RequestBody StudentRecordDto studentRecordDto){
        return ResponseEntity.ok(studentService.updateStudent(idStudent, studentRecordDto));
    }

    @DeleteMapping("/{idStudent}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value="idStudent") UUID idStudent){
        studentService.deleteStudent(idStudent);
        return ResponseEntity.ok("Student deleted successfully.");
    }
}
