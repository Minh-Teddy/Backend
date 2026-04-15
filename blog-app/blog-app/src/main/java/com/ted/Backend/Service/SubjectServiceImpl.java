package com.ted.Backend.Service;

import com.ted.Backend.Dto.SubjectDto;
import com.ted.Backend.Entity.Subject;
import com.ted.Backend.Form.SubjectCreateForm;
import com.ted.Backend.Form.SubjectUpdateForm;
import com.ted.Backend.Mapper.SubjectMapper;
import com.ted.Backend.Repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;
    private SubjectMapper subjectMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SubjectDto> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SubjectDto> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable)
                .map(subjectMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public SubjectDto findById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môn học với id: " + id));
        return subjectMapper.toDto(subject);
    }

    @Override
    @Transactional(readOnly = true)
    public SubjectDto findByIdsubject(String idsubject) {
        Subject subject = subjectRepository.findByIdsubject(idsubject)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môn học với mã: " + idsubject));
        return subjectMapper.toDto(subject);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubjectDto> findByName(String name) {
        return subjectRepository.findBySubjectnameContainingIgnoreCase(name)
                .stream()
                .map(subjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SubjectDto> findByName(String name, Pageable pageable) {
        return subjectRepository.findBySubjectnameContainingIgnoreCase(name, pageable)
                .map(subjectMapper::toDto);
    }

    @Override
    @Transactional
    public SubjectDto create(SubjectCreateForm form) {
        if (subjectRepository.existsByIdsubject(form.getIdsubject())) {
            throw new RuntimeException("Mã môn học đã tồn tại: " + form.getIdsubject());
        }
        Subject subject = subjectMapper.toEntity(form);
        return subjectMapper.toDto(subjectRepository.save(subject));
    }

    @Override
    @Transactional
    public SubjectDto update(Long id, SubjectUpdateForm form) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môn học với id: " + id));

        if (form.getIdsubject() != null && !form.getIdsubject().equals(subject.getIdsubject())) {
            if (subjectRepository.existsByIdsubject(form.getIdsubject())) {
                throw new RuntimeException("Mã môn học đã tồn tại: " + form.getIdsubject());
            }
        }

        subjectMapper.updateEntity(subject, form);
        return subjectMapper.toDto(subjectRepository.save(subject));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy môn học với id: " + id);
        }
        subjectRepository.deleteById(id);
    }
}
