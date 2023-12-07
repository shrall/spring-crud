package com.example.employeemanagement.service;

import java.util.List;

import com.example.employeemanagement.entity.EmployeeEntity;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(Long id);

    EmployeeEntity create(EmployeeEntity employeeEntity);

    EmployeeEntity update(Long id, EmployeeEntity employeeEntity);

    void deleteById(Long id);
}
