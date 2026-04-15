package com.ted.Backend.Repository;

import com.ted.Backend.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Phân trang toàn bộ
    Page<Student> findAll(Pageable pageable);

    // Phân trang theo tên
    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Phân trang theo lớp
    Page<Student> findByClassname(String classname, Pageable pageable);

    // Phân trang theo khóa học
    Page<Student> findByGeneration(Integer generation, Pageable pageable);

    Optional<Student> findByIdstudent(String idstudent);

    boolean existsByIdstudent(String idstudent);

    boolean existsByEmail(String email);

    List<Student> findByClassname(String classname);

    List<Student> findByGeneration(Integer generation);

    List<Student> findByNameContainingIgnoreCase(String name);
}
