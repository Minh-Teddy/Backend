package com.ted.Backend.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScoreBoardDto {
    private Long id;
    private Integer idscoreboard;
    private Float processscore;
    private Float componentscore;
    private Float finalscore;
    private Boolean ispassed;
    private LocalDateTime registereddate;
    private Long studentId;
    private String idstudent;
    private String studentName;
    private Long subjectId;
    private String idsubject;
    private String subjectname;
}
