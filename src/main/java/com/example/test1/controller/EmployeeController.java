package com.example.test1.controller;


import com.example.test1.model.Employee;
import com.example.test1.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;


    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<Iterable<Employee>> findAllAge() {
        return new ResponseEntity<>(employeeService.findAllByOrderByAgeAsc(), HttpStatus.OK);
    }


    @GetMapping("/sortEmployeeByDepartment/{id}")
    public ResponseEntity<Iterable<Employee>> sortProductByCategory(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findAllByDepartment_Id(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id){
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setId(employeeOptional.get().getId());
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.remove(id);
        return new ResponseEntity<>("Delete done!", HttpStatus.OK);
    }

}
