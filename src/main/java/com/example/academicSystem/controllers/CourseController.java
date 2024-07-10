package com.example.academicSystem.controllers;


import com.example.academicSystem.domain.course.CourseRecordDto;
import com.example.academicSystem.domain.course.Course;
import com.example.academicSystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody CourseRecordDto courseRecordDto) {
        Course course = courseService.createCourse(courseRecordDto);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseRecordDto>> getCourses() {
        return ResponseEntity.ok(courseService.findCourses());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseRecordDto> getCourseById(@PathVariable(value = "courseId")UUID id) {
        CourseRecordDto course = courseService.findCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "courseId")UUID id,
                                               @RequestBody CourseRecordDto courseRecordDto) {
        Course course = courseService.updateCourse(id, courseRecordDto);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable(value = "courseId")UUID id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }
}
