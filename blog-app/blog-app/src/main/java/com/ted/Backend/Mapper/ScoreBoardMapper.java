package com.ted.Backend.Mapper;

import com.ted.Backend.Dto.ScoreBoardDto;
import com.ted.Backend.Entity.ScoreBoard;
import com.ted.Backend.Entity.Student;
import com.ted.Backend.Entity.Subject;
import com.ted.Backend.Form.ScoreBoardCreateForm;
import com.ted.Backend.Form.ScoreBoardUpdateForm;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Component
public class ScoreBoardMapper {


    public ScoreBoardDto toDto(ScoreBoard scoreBoard) {
        if (scoreBoard == null) return null;

        ScoreBoardDto dto = new ScoreBoardDto();
        dto.setId(scoreBoard.getId());
        dto.setIdscoreboard(scoreBoard.getIdscoreboard());
        dto.setProcessscore(scoreBoard.getProcessscore());
        dto.setComponentscore(scoreBoard.getComponentscore());
        dto.setFinalscore(scoreBoard.getFinalscore());
        dto.setIspassed(scoreBoard.getIspassed());
        dto.setRegistereddate(scoreBoard.getRegistereddate());

        // Thông tin sinh viên
        if (scoreBoard.getStudent() != null) {
            dto.setStudentId(scoreBoard.getStudent().getId());
            dto.setIdstudent(scoreBoard.getStudent().getIdstudent());
            dto.setStudentName(scoreBoard.getStudent().getName());
        }

        // Thông tin môn học
        if (scoreBoard.getSubject() != null) {
            dto.setSubjectId(scoreBoard.getSubject().getId());
            dto.setIdsubject(scoreBoard.getSubject().getIdsubject());
            dto.setSubjectname(scoreBoard.getSubject().getSubjectname());
        }

        return dto;
    }


    public ScoreBoard toEntity(ScoreBoardCreateForm form, Student student, Subject subject) {
        if (form == null) return null;

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setProcessscore(form.getProcessscore());
        scoreBoard.setComponentscore(form.getComponentscore());
        scoreBoard.setFinalscore(form.getFinalscore());
        scoreBoard.setRegistereddate(LocalDateTime.now());
        scoreBoard.setStudent(student);
        scoreBoard.setSubject(subject);

        // Tính toán ispassed dựa vào passscore của môn học
        if (form.getFinalscore() != null && subject != null && subject.getPassscore() != null) {
            scoreBoard.setIspassed(form.getFinalscore() >= subject.getPassscore());
        } else {
            scoreBoard.setIspassed(false);
        }

        return scoreBoard;
    }


    public void updateEntity(ScoreBoard scoreBoard, ScoreBoardUpdateForm form, Float passscore) {
        if (form == null || scoreBoard == null) return;

        if (form.getProcessscore() != null) scoreBoard.setProcessscore(form.getProcessscore());
        if (form.getComponentscore() != null) scoreBoard.setComponentscore(form.getComponentscore());
        if (form.getFinalscore() != null) {
            scoreBoard.setFinalscore(form.getFinalscore());
            // Cập nhật lại trạng thái đậu/rớt
            if (passscore != null) {
                scoreBoard.setIspassed(form.getFinalscore() >= passscore);
            }
        }
    }
}
