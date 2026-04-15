package com.ted.Backend.Form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreBoardCreateForm {
    private Float processscore;
    private Float componentscore;
    private Float finalscore;
    private Long studentId;
    private Long subjectId;
}
