package com.ted.Backend.Repository;

import com.ted.Backend.Entity.ScoreBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreBoardRepository extends JpaRepository<ScoreBoard, Long> {

    // Phân trang toàn bộ
    Page<ScoreBoard> findAll(Pageable pageable);

    // Phân trang theo sinh viên
    Page<ScoreBoard> findByStudent_Id(Long studentId, Pageable pageable);

    // Phân trang theo môn học
    Page<ScoreBoard> findBySubject_Id(Long subjectId, Pageable pageable);

    List<ScoreBoard> findByStudent_Id(Long studentId);

    List<ScoreBoard> findBySubject_Id(Long subjectId);

    List<ScoreBoard> findByStudent_Idstudent(String idstudent);

    List<ScoreBoard> findBySubject_Idsubject(String idsubject);

    boolean existsByStudent_IdAndSubject_Id(Long studentId, Long subjectId);
}
