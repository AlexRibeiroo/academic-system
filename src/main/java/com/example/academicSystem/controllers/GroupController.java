package com.example.academicSystem.controllers;

import com.example.academicSystem.domain.group.Group;
import com.example.academicSystem.domain.group.GroupRecordDto;
import com.example.academicSystem.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody GroupRecordDto groupRecordDto){
        Group group = groupService.createGroup(groupRecordDto);
        return ResponseEntity.ok(group);
    }

    @GetMapping
    public ResponseEntity<List<GroupRecordDto>> getGroups(){
        return ResponseEntity.ok(groupService.findGroups());
    }

    @GetMapping("/{idGroup}")
    public ResponseEntity<GroupRecordDto> getGroupById(@PathVariable UUID idGroup){
        return ResponseEntity.ok(groupService.findGroupById(idGroup));
    }

    @PutMapping("/{idGroup}")
    public ResponseEntity<Group> updateGroup(@PathVariable UUID idGroup, @RequestBody GroupRecordDto groupRecordDto){
        return ResponseEntity.ok(groupService.updateGroup(idGroup, groupRecordDto));
    }

    @DeleteMapping("/{idGroup}")
    public ResponseEntity<Object> deleteGroup(@PathVariable UUID idGroup){
        groupService.deleteGroup(idGroup);
        return ResponseEntity.ok("Group deleted successfully.");
    }
}
