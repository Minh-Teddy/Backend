package com.ted.Backend.Service;

import com.ted.Backend.Dto.ScoreBoardDto;
import com.ted.Backend.Entity.ScoreBoard;
import com.ted.Backend.Entity.Student;
import com.ted.Backend.Entity.Subject;
import com.ted.Backend.Form.ScoreBoardCreateForm;
import com.ted.Backend.Form.ScoreBoardUpdateForm;
import com.ted.Backend.Mapper.ScoreBoardMapper;
import com.ted.Backend.Repository.ScoreBoardRepository;
import com.ted.Backend.Repository.StudentRepository;
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
public class ScoreBoardServiceImpl implements ScoreBoardService {

    private ScoreBoardRepository scoreBoardRepository;
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    private ScoreBoardMapper scoreBoardMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ScoreBoardDto> findAll() {
        return scoreBoardRepository.findAll()
                .stream()
                .map(scoreBoardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ScoreBoardDto> findAll(Pageable pageable) {
        return scoreBoardRepository.findAll(pageable)
                .map(scoreBoardMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public ScoreBoardDto findById(Long id) {
        ScoreBoard scoreBoard = scoreBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bảng điểm với id: " + id));
        return scoreBoardMapper.toDto(scoreBoard);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ScoreBoardDto> findByStudentId(Long studentId) {
        return scoreBoardRepository.findByStudent_Id(studentId)
                .stream()
                .map(scoreBoardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ScoreBoardDto> findByStudentId(Long studentId, Pageable pageable) {
        return scoreBoardRepository.findByStudent_Id(studentId, pageable)
                .map(scoreBoardMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ScoreBoardDto> findBySubjectId(Long subjectId, Pageable pageable) {
        return scoreBoardRepository.findBySubject_Id(subjectId, pageable)
                .map(scoreBoardMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ScoreBoardDto> findByIdstudent(String idstudent) {
        return scoreBoardRepository.findByStudent_Idstudent(idstudent)
                .stream()
                .map(scoreBoardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ScoreBoardDto> findByIdsubject(String idsubject) {
        return scoreBoardRepository.findBySubject_Idsubject(idsubject)
                .stream()
                .map(scoreBoardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ScoreBoardDto create(ScoreBoardCreateForm form) {
        Student student = studentRepository.findById(form.getStudentId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với id: " + form.getStudentId()));
        Subject subject = subjectRepository.findById(form.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy môn học với id: " + form.getSubjectId()));

        if (scoreBoardRepository.existsByStudent_IdAndSubject_Id(form.getStudentId(), form.getSubjectId())) {
            throw new RuntimeException("Sinh viên đã đăng ký môn học này rồi");
        }

        ScoreBoard scoreBoard = scoreBoardMapper.toEntity(form, student, subject);
        return scoreBoardMapper.toDto(scoreBoardRepository.save(scoreBoard));
    }

    @Override
    @Transactional
    public ScoreBoardDto update(Long id, ScoreBoardUpdateForm form) {
        ScoreBoard scoreBoard = scoreBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bảng điểm với id: " + id));

        Float passscore = scoreBoard.getSubject() != null ? scoreBoard.getSubject().getPassscore() : null;
        scoreBoardMapper.updateEntity(scoreBoard, form, passscore);
        return scoreBoardMapper.toDto(scoreBoardRepository.save(scoreBoard));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!scoreBoardRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy bảng điểm với id: " + id);
        }
        scoreBoardRepository.deleteById(id);
    }
}
