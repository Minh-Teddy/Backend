package com.ted.Backend.Service;

import com.ted.Backend.Dto.SubjectDto;
import com.ted.Backend.Form.SubjectCreateForm;
import com.ted.Backend.Form.SubjectUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {

    List<SubjectDto> findAll();

    Page<SubjectDto> findAll(Pageable pageable);

    SubjectDto findById(Long id);

    SubjectDto findByIdsubject(String idsubject);

    List<SubjectDto> findByName(String name);

    Page<SubjectDto> findByName(String name, Pageable pageable);

    SubjectDto create(SubjectCreateForm form);

    SubjectDto update(Long id, SubjectUpdateForm form);

    void deleteById(Long id);
}
