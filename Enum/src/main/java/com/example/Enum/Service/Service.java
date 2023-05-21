package com.example.Enum.Service;

import com.example.Enum.Dto.*;
import com.example.Enum.Entity.Employee;
import com.example.Enum.Entity.EmployeeStringEnum;
import com.example.Enum.Entity.ThreeParameterEmployee;
import com.example.Enum.Enum.Designation;
import com.example.Enum.Enum.DesignationSalary;
import com.example.Enum.Repository.EmployeeRepository;
import com.example.Enum.Repository.EmployeeStringRepository;
import com.example.Enum.Repository.ThreeParamEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final String SUCCESSFULLY_SAVED_DATA = "Data saved successfully";
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeStringRepository employeeStringRepository;
    @Autowired
    ThreeParamEmployeeRepository threeParamEmployeeRepository;

    public ResponseEntity<String> postEmployeeNormalEnum(RequestEmployee requestEmployee) {
        Employee employee = convertDtoToEntity(requestEmployee);
        employeeRepository.save(employee);
        return ResponseEntity.ok(SUCCESSFULLY_SAVED_DATA);
    }

    private Employee convertDtoToEntity(RequestEmployee requestEmployee) {
        return Employee.builder()
                .name(requestEmployee.getName())
                .designation(requestEmployee.getDesignation())
                .build();
    }

    public ResponseEntity<String> postEmployeeStringEnum(StringRequestEmployee stringRequestEmployee) {
        EmployeeStringEnum employeeStringEnum = convertStringEnumDtoToEntity(stringRequestEmployee);
        employeeStringRepository.save(employeeStringEnum);
        return ResponseEntity.ok(SUCCESSFULLY_SAVED_DATA);
    }

    private EmployeeStringEnum convertStringEnumDtoToEntity(StringRequestEmployee stringRequestEmployee) {
        return EmployeeStringEnum.builder()
                .name(stringRequestEmployee.getName())
                .designation(stringRequestEmployee.getDesignation())
                .build();
    }

    public ResponseEntity<ResponseEmployee> getEmployeeInfo(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        ResponseEmployee responseEmployee = new ResponseEmployee();
        if (employee.isPresent()) {
            responseEmployee.setId(employee.get().getId());
            responseEmployee.setName(employee.get().getName());
            responseEmployee.setDesignation(employee.get().getDesignation());
        }
        return ResponseEntity.ok(responseEmployee);
    }

    public ResponseEntity<StringResponseEmployees> getStringEmployeeInfo(Long id) {
        Optional<EmployeeStringEnum> employeeStringEnum = employeeStringRepository.findById(id);
        StringResponseEmployees stringResponseEmployees = new StringResponseEmployees();
        if (employeeStringEnum.isPresent()) {
            stringResponseEmployees.setId(employeeStringEnum.get().getId());
            stringResponseEmployees.setName(employeeStringEnum.get().getName());
            stringResponseEmployees.setDesignation(employeeStringEnum.get().getDesignation());
        }
        return ResponseEntity.ok(stringResponseEmployees);
    }

    public ResponseEntity<String> getSpecificMessage(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            if (employee.get().getDesignation().equals(Designation.SOFTWARE_ENGINEER)) {
                return ResponseEntity.ok("He is software engineer");
            }
            return null;
        } else {
            return null;
        }
    }

    public ResponseEntity<String> postThreeParamEmployee(RequestThreeEmployees requestThreeEmployees) {
        ThreeParameterEmployee threeParameterEmployee = convertThreeParamDtoToEntity(requestThreeEmployees);
        threeParamEmployeeRepository.save(threeParameterEmployee);
        return ResponseEntity.ok(SUCCESSFULLY_SAVED_DATA);
    }

    private ThreeParameterEmployee convertThreeParamDtoToEntity(RequestThreeEmployees requestThreeEmployees) {
        return ThreeParameterEmployee.builder()
                .name(requestThreeEmployees.getName())
                .designationSalary(requestThreeEmployees.getDesignationSalary())
                .build();
    }

    public ResponseEntity<ResponseThreeEmployees> getThreeEmployeeInfo(Long id) {
        Optional<ThreeParameterEmployee> threeParameterEmployee = threeParamEmployeeRepository.findById(id);
        ResponseThreeEmployees responseEmployee = new ResponseThreeEmployees();
        if (threeParameterEmployee.isPresent()) {
            responseEmployee.setId(threeParameterEmployee.get().getId());
            responseEmployee.setName(threeParameterEmployee.get().getName());
            responseEmployee.setDesignationSalary(threeParameterEmployee.get().getDesignationSalary());
        }
        return ResponseEntity.ok(responseEmployee);
    }

    public ResponseEntity<ResponseAllInfoOfThreeParamEmployee> getThreeEmployeeAllInfo(Long id) {
        Optional<ThreeParameterEmployee> threeParameterEmployee = threeParamEmployeeRepository.findById(id);
        ResponseAllInfoOfThreeParamEmployee responseAllInfoOfThreeParamEmployee = new ResponseAllInfoOfThreeParamEmployee();
        if (threeParameterEmployee.isPresent()) {
            responseAllInfoOfThreeParamEmployee.setId(threeParameterEmployee.get().getId());
            responseAllInfoOfThreeParamEmployee.setName(threeParameterEmployee.get().getName());
            responseAllInfoOfThreeParamEmployee.setDesignationOrder(threeParameterEmployee.get().getDesignationSalary().getOrder());
            responseAllInfoOfThreeParamEmployee.setDesignation(threeParameterEmployee.get().getDesignationSalary().getDesignation());
            responseAllInfoOfThreeParamEmployee.setSalary(threeParameterEmployee.get().getDesignationSalary().getSalary());
        }
        return ResponseEntity.ok(responseAllInfoOfThreeParamEmployee);
    }
}
