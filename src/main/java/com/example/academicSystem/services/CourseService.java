package com.example.academicSystem.services;

import com.example.academicSystem.domain.course.CourseRecordDto;
import com.example.academicSystem.domain.course.Course;
import com.example.academicSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(CourseRecordDto data){
        Course newCourse = new Course();
        newCourse.setName(data.name());
        newCourse.setCourseHours(data.courseHours());
        newCourse.setValue(data.value());
        newCourse.setMinimumScore(data.minimumScore());

        return courseRepository.save(newCourse);
    }

    public List<CourseRecordDto> findCourses(){
        List<Course> listCourse = courseRepository.findAll();

        return listCourse.stream().map(course -> new CourseRecordDto(
                course.getName(),
                course.getCourseHours(),
                course.getValue(),
                course.getMinimumScore()
        )).toList();
    }

    public CourseRecordDto findCourseById(UUID id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        return new CourseRecordDto(
                course.getName(),
                course.getCourseHours(),
                course.getValue(),
                course.getMinimumScore()
        );

    }

    public Course updateCourse(UUID id, CourseRecordDto data){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        course.setName(data.name());
        course.setCourseHours(data.courseHours());
        course.setValue(data.value());
        course.setMinimumScore(data.minimumScore());
        courseRepository.save(course);
        return course;
    }

    public void deleteCourse(UUID id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        courseRepository.delete(course);
    }

}
