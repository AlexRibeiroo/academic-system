package com.example.academicSystem.repositories;

import com.example.academicSystem.domain.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
