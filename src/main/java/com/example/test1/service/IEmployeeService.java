package com.example.test1.service;

import com.example.test1.model.Employee;

public interface IEmployeeService extends IGeneralService<Employee> {
    Iterable<Employee> findAllByOrderByAgeAsc();
    Iterable<Employee> findAllByDepartment_Id(Long id);

}
