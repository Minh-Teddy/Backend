package com.ted.Backend.Service;

import com.ted.Backend.Dto.StudentDto;
import com.ted.Backend.Entity.Student;
import com.ted.Backend.Form.StudentCreateForm;
import com.ted.Backend.Form.StudentUpdateForm;
import com.ted.Backend.Mapper.StudentMapper;
import com.ted.Backend.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDto> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với id: " + id));
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto findByIdstudent(String idstudent) {
        Student student = studentRepository.findByIdstudent(idstudent)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với mã: " + idstudent));
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> findByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDto> findByName(String name, Pageable pageable) {
        return studentRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(studentMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> findByClassname(String classname) {
        return studentRepository.findByClassname(classname)
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDto> findByClassname(String classname, Pageable pageable) {
        return studentRepository.findByClassname(classname, pageable)
                .map(studentMapper::toDto);
    }

    @Override
    @Transactional
    public StudentDto create(StudentCreateForm form) {
        if (studentRepository.existsByIdstudent(form.getIdstudent())) {
            throw new RuntimeException("Mã sinh viên đã tồn tại: " + form.getIdstudent());
        }
        if (studentRepository.existsByEmail(form.getEmail())) {
            throw new RuntimeException("Email đã tồn tại: " + form.getEmail());
        }
        Student student = studentMapper.toEntity(form);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    @Transactional
    public StudentDto update(Long id, StudentUpdateForm form) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với id: " + id));

        if (form.getIdstudent() != null && !form.getIdstudent().equals(student.getIdstudent())) {
            if (studentRepository.existsByIdstudent(form.getIdstudent())) {
                throw new RuntimeException("Mã sinh viên đã tồn tại: " + form.getIdstudent());
            }
        }
        if (form.getEmail() != null && !form.getEmail().equals(student.getEmail())) {
            if (studentRepository.existsByEmail(form.getEmail())) {
                throw new RuntimeException("Email đã tồn tại: " + form.getEmail());
            }
        }

        studentMapper.updateEntity(student, form);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy sinh viên với id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
