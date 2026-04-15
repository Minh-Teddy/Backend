package com.ted.Backend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {
    private Long id;
    private String idsubject;
    private String subjectname;
    private Integer totalperiod;
    private Float processratio;
    private Float componentratio;
    private Float passscore;
}
