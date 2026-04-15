package com.ted.Backend.Mapper;

import com.ted.Backend.Dto.SubjectDto;
import com.ted.Backend.Entity.Subject;
import com.ted.Backend.Form.SubjectCreateForm;
import com.ted.Backend.Form.SubjectUpdateForm;
import org.springframework.stereotype.Component;


@Component
public class SubjectMapper {


    public SubjectDto toDto(Subject subject) {
        if (subject == null) return null;

        SubjectDto dto = new SubjectDto();
        dto.setId(subject.getId());
        dto.setIdsubject(subject.getIdsubject());
        dto.setSubjectname(subject.getSubjectname());
        dto.setTotalperiod(subject.getTotalperiod());
        dto.setProcessratio(subject.getProcessratio());
        dto.setComponentratio(subject.getComponentratio());
        dto.setPassscore(subject.getPassscore());
        return dto;
    }


    public Subject toEntity(SubjectCreateForm form) {
        if (form == null) return null;

        Subject subject = new Subject();
        subject.setIdsubject(form.getIdsubject());
        subject.setSubjectname(form.getSubjectname());
        subject.setTotalperiod(form.getTotalperiod());
        subject.setProcessratio(form.getProcessratio());
        subject.setComponentratio(form.getComponentratio());
        subject.setPassscore(form.getPassscore());
        return subject;
    }


    public void updateEntity(Subject subject, SubjectUpdateForm form) {
        if (form == null || subject == null) return;

        if (form.getIdsubject() != null) subject.setIdsubject(form.getIdsubject());
        if (form.getSubjectname() != null) subject.setSubjectname(form.getSubjectname());
        if (form.getTotalperiod() != null) subject.setTotalperiod(form.getTotalperiod());
        if (form.getProcessratio() != null) subject.setProcessratio(form.getProcessratio());
        if (form.getComponentratio() != null) subject.setComponentratio(form.getComponentratio());
        if (form.getPassscore() != null) subject.setPassscore(form.getPassscore());
    }
}
