package com.ted.Backend.Mapper;

import com.ted.Backend.Dto.StudentDto;
import com.ted.Backend.Entity.Student;
import com.ted.Backend.Form.StudentCreateForm;
import com.ted.Backend.Form.StudentUpdateForm;
import org.springframework.stereotype.Component;


@Component
public class StudentMapper {

    public StudentDto toDto(Student student) {
        if (student == null) return null;

        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setIdstudent(student.getIdstudent());
        dto.setName(student.getName());
        dto.setGender(student.getGender());
        dto.setDate(student.getDate());
        dto.setClassname(student.getClassname());
        dto.setGeneration(student.getGeneration());
        dto.setPhonenumber(student.getPhonenumber());
        dto.setEmail(student.getEmail());
        return dto;
    }

    /**
     * Chuyển CreateForm -> Entity (khi tạo mới)
     */
    public Student toEntity(StudentCreateForm form) {
        if (form == null) return null;

        Student student = new Student();
        student.setIdstudent(form.getIdstudent());
        student.setName(form.getName());
        student.setGender(form.getGender());
        student.setDate(form.getDate());
        student.setClassname(form.getClassname());
        student.setGeneration(form.getGeneration());
        student.setPhonenumber(form.getPhonenumber());
        student.setEmail(form.getEmail());
        return student;
    }

    /**
     * Cập nhật Entity từ UpdateForm (khi update)
     */
    public void updateEntity(Student student, StudentUpdateForm form) {
        if (form == null || student == null) return;

        if (form.getIdstudent() != null) student.setIdstudent(form.getIdstudent());
        if (form.getName() != null) student.setName(form.getName());
        if (form.getGender() != null) student.setGender(form.getGender());
        if (form.getDate() != null) student.setDate(form.getDate());
        if (form.getClassname() != null) student.setClassname(form.getClassname());
        if (form.getGeneration() != null) student.setGeneration(form.getGeneration());
        if (form.getPhonenumber() != null) student.setPhonenumber(form.getPhonenumber());
        if (form.getEmail() != null) student.setEmail(form.getEmail());
    }
}
