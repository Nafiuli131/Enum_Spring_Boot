package com.example.Enum.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAllInfoOfThreeParamEmployee {
    private Long id;
    private String name;
    private int designationOrder;
    private String designation;
    private int salary;
}
