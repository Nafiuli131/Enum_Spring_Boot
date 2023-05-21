package com.example.Enum.Dto;

import com.example.Enum.Enum.Designation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployee {
    private String name;
    private Designation designation;
}
