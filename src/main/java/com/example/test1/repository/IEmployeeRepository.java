package com.example.test1.repository;

import com.example.test1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

        Iterable<Employee> findAllByOrderByAgeAsc();
        Iterable<Employee> findAllByDepartment_Id(Long id);

}