package com.example.academicSystem.services;

import com.example.academicSystem.domain.student.Student;
import com.example.academicSystem.domain.student.StudentRecordDto;
import com.example.academicSystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentRecordDto data){
        Student newStudent = new Student();
        newStudent.setName(data.name());
        newStudent.setCpf(data.cpf());
        newStudent.setBirth(data.birth());

        return studentRepository.save(newStudent);
    }

    public List<StudentRecordDto> findStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> new StudentRecordDto(
                student.getName(),
                student.getCpf(),
                student.getBirth()
        )).toList();
    }

    public StudentRecordDto findStudentById(UUID id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found!"));

        return new StudentRecordDto(
                student.getName(),
                student.getCpf(),
                student.getBirth()
        );
    }

    public Student updateStudent(UUID id, StudentRecordDto data){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found!"));

        student.setName(data.name());
        student.setCpf(data.cpf());
        student.setBirth(data.birth());

        return studentRepository.save(student);
    }

    public Student deleteStudent(UUID id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found!"));

        studentRepository.delete(student);
        return student;
    }

}
