package com.example.test1.repository;

import com.example.test1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Long> {
}
