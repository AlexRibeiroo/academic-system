package com.example.academicSystem.services;

import com.example.academicSystem.domain.course.Course;
import com.example.academicSystem.domain.group.Group;
import com.example.academicSystem.domain.group.GroupRecordDto;
import com.example.academicSystem.repositories.CourseRepository;
import com.example.academicSystem.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Group createGroup(GroupRecordDto data){
        Group newGroup = new Group();
        Course course = courseRepository.findById(data.idCourse()).
                orElseThrow(() -> new IllegalArgumentException("Course not found"));
        newGroup.setNumber(data.number());
        newGroup.setInitialDate(data.initialDate());
        newGroup.setVacanciesNumber(data.vacanciesNumber());
        newGroup.setCourse(course);

        return groupRepository.save(newGroup);
    }

    public List<GroupRecordDto> findGroups(){
        List<Group> groupList = groupRepository.findAll();

        return groupList.stream().map(group -> new GroupRecordDto(
                group.getNumber(),
                group.getInitialDate(),
                group.getVacanciesNumber(),
                group.getCourse().getId()
        )).toList();
    }

    public GroupRecordDto findGroupById(UUID id){
        Group group = groupRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Group not found!"));
        return new GroupRecordDto(
                group.getNumber(),
                group.getInitialDate(),
                group.getVacanciesNumber(),
                group.getCourse().getId()
        );
    }

    public Group updateGroup(UUID id, GroupRecordDto data){
        Group group = groupRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Group not found!"));
        group.setNumber(data.number());
        group.setInitialDate(data.initialDate());
        group.setVacanciesNumber(data.vacanciesNumber());
        return groupRepository.save(group);
    }

    public void deleteGroup(UUID id){
        Group group = groupRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Group not found!"));
        groupRepository.delete(group);

    }
}
