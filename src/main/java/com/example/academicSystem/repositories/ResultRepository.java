package com.example.academicSystem.repositories;

import com.example.academicSystem.domain.result.Result;
import com.example.academicSystem.domain.result.ResultId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, ResultId> {
}
