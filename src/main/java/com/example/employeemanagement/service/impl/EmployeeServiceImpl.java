package com.example.employeemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeemanagement.entity.EmployeeEntity;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
        try {
            employees = employeeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Transactional
    public EmployeeEntity getEmployeeById(Long id) {
        EmployeeEntity employee = new EmployeeEntity();
        try {
            employee = employeeRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Transactional
    public EmployeeEntity create(EmployeeEntity employee) {
        EmployeeEntity newEmployee = new EmployeeEntity();
        try {
            newEmployee = employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newEmployee;
    }

    @Transactional
    public EmployeeEntity update(Long id, EmployeeEntity employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        try {
            existingEmployee.setName(employee.getName());
            existingEmployee.setGender(employee.getGender());
            existingEmployee.setDob(employee.getDob());
            existingEmployee.setAddress(employee.getAddress());
            return employeeRepository.save(existingEmployee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existingEmployee;
    }

    @Transactional
    public void deleteById(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
