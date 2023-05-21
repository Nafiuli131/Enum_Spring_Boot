package com.example.Enum.Entity;

import com.example.Enum.Enum.Designation;
import com.example.Enum.Enum.DesignationSalary;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "three_parameter_employee")
public class ThreeParameterEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private DesignationSalary designationSalary;
}
