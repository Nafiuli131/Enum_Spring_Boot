package com.example.Enum.Dto;

import com.example.Enum.Enum.Designation;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployee {
    private Long id;
    private String name;
    private Designation designation;
}
