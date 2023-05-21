package com.example.Enum.Dto;

import com.example.Enum.Enum.Designation;
import com.example.Enum.Enum.DesignationSalary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestThreeEmployees {
    private String name;
    private DesignationSalary designationSalary;
}
