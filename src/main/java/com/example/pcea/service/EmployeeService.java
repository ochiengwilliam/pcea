package com.example.pcea.service;

import com.example.pcea.entities.Employee;
import com.example.pcea.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(employeeDetails.getFirstName());
                    employee.setMiddleName(employeeDetails.getMiddleName());
                    employee.setLastName(employeeDetails.getLastName());
                    employee.setNationalId(employeeDetails.getNationalId());
                    employee.setMobile(employeeDetails.getMobile());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
