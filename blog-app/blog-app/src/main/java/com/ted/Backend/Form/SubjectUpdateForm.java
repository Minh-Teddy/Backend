package com.ted.Backend.Form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SubjectUpdateForm {
    private String idsubject;
    private String subjectname;
    private Integer totalperiod;
    private Float processratio;
    private Float componentratio;
    private Float passscore;
}
