package com.ted.Backend.Dto;

import com.ted.Backend.Entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String idstudent;
    private String name;
    private Student.Gender gender;
    private LocalDate date;
    private String classname;
    private Integer generation;
    private String phonenumber;
    private String email;
}
