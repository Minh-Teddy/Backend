package com.ted.Backend.Repository;

import com.ted.Backend.Entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    // Phân trang toàn bộ
    Page<Subject> findAll(Pageable pageable);

    // Phân trang theo tên môn
    Page<Subject> findBySubjectnameContainingIgnoreCase(String subjectname, Pageable pageable);

    Optional<Subject> findByIdsubject(String idsubject);

    boolean existsByIdsubject(String idsubject);

    List<Subject> findBySubjectnameContainingIgnoreCase(String subjectname);
}
