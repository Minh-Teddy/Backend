package com.ted.Backend.Service;

import com.ted.Backend.Dto.StudentDto;
import com.ted.Backend.Form.StudentCreateForm;
import com.ted.Backend.Form.StudentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    Page<StudentDto> findAll(Pageable pageable);

    StudentDto findById(Long id);

    StudentDto findByIdstudent(String idstudent);

    List<StudentDto> findByName(String name);

    Page<StudentDto> findByName(String name, Pageable pageable);

    List<StudentDto> findByClassname(String classname);

    Page<StudentDto> findByClassname(String classname, Pageable pageable);

    StudentDto create(StudentCreateForm form);

    StudentDto update(Long id, StudentUpdateForm form);

    void deleteById(Long id);
}
