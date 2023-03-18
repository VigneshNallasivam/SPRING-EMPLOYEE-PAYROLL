package com.example.employeepayroll.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDto
{
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}",message = "First Letter Should Be Capital")
    private String name;
    @NotEmpty(message = "Is Profile Picture Empty!!")
    private String pic;
    @NotNull(message = "Must Enter Gender value")
    private String gender;
    private String salary;
    private String notes;
    private String startDate;
    private List<String> department;
}
