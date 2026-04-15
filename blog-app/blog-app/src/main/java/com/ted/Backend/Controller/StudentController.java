package com.ted.Backend.Controller;

import com.ted.Backend.Dto.StudentDto;
import com.ted.Backend.Form.StudentCreateForm;
import com.ted.Backend.Form.StudentUpdateForm;
import com.ted.Backend.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    // ── Có phân trang ─────────────────────────────────────────────────

    @GetMapping("/api/v1/students/page")
    public Page<StudentDto> findAllPage(
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return studentService.findAll(pageable);
    }

    @GetMapping("/api/v1/students/page/search")
    public Page<StudentDto> searchByNamePage(
            @RequestParam("name") String name,
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return studentService.findByName(name, pageable);
    }

    @GetMapping("/api/v1/students/page/class/{classname}")
    public Page<StudentDto> findByClassnamePage(
            @PathVariable("classname") String classname,
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return studentService.findByClassname(classname, pageable);
    }

    // ── Không phân trang ──────────────────────────────────────────────

    @GetMapping("/api/v1/students")
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/api/v1/students/{id}")
    public StudentDto findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/api/v1/students/code/{idstudent}")
    public StudentDto findByIdstudent(@PathVariable("idstudent") String idstudent) {
        return studentService.findByIdstudent(idstudent);
    }

    @GetMapping("/api/v1/students/search")
    public List<StudentDto> searchByName(@RequestParam("name") String name) {
        return studentService.findByName(name);
    }

    @GetMapping("/api/v1/students/class/{classname}")
    public List<StudentDto> findByClassname(@PathVariable("classname") String classname) {
        return studentService.findByClassname(classname);
    }

    // ── Ghi ───────────────────────────────────────────────────────────

    @PostMapping("/api/v1/students")
    public StudentDto create(@RequestBody StudentCreateForm form) {
        return studentService.create(form);
    }

    @PutMapping("/api/v1/students/{id}")
    public StudentDto update(@RequestBody StudentUpdateForm form,
                             @PathVariable("id") Long id) {
        return studentService.update(id, form);
    }

    @DeleteMapping("/api/v1/students/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }
}
