package com.ted.Backend.Service;

import com.ted.Backend.Dto.ScoreBoardDto;
import com.ted.Backend.Form.ScoreBoardCreateForm;
import com.ted.Backend.Form.ScoreBoardUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ScoreBoardService {

    List<ScoreBoardDto> findAll();

    Page<ScoreBoardDto> findAll(Pageable pageable);

    ScoreBoardDto findById(Long id);

    List<ScoreBoardDto> findByStudentId(Long studentId);

    Page<ScoreBoardDto> findByStudentId(Long studentId, Pageable pageable);

    Page<ScoreBoardDto> findBySubjectId(Long subjectId, Pageable pageable);

    List<ScoreBoardDto> findByIdstudent(String idstudent);

    List<ScoreBoardDto> findByIdsubject(String idsubject);

    ScoreBoardDto create(ScoreBoardCreateForm form);

    ScoreBoardDto update(Long id, ScoreBoardUpdateForm form);

    void deleteById(Long id);
}
