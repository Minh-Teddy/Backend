package com.ted.Backend.Controller;

import com.ted.Backend.Dto.ScoreBoardDto;
import com.ted.Backend.Form.ScoreBoardCreateForm;
import com.ted.Backend.Form.ScoreBoardUpdateForm;
import com.ted.Backend.Service.ScoreBoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ScoreBoardController {

    private ScoreBoardService scoreBoardService;

    // ── Có phân trang ─────────────────────────────────────────────────

    @GetMapping("/api/v1/scoreboards/page")
    public Page<ScoreBoardDto> findAllPage(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return scoreBoardService.findAll(pageable);
    }

    @GetMapping("/api/v1/scoreboards/page/student/{studentId}")
    public Page<ScoreBoardDto> findByStudentIdPage(
            @PathVariable("studentId") Long studentId,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return scoreBoardService.findByStudentId(studentId, pageable);
    }

    @GetMapping("/api/v1/scoreboards/page/subject/{subjectId}")
    public Page<ScoreBoardDto> findBySubjectIdPage(
            @PathVariable("subjectId") Long subjectId,
            @PageableDefault(size = 10, sort = "finalscore", direction = Sort.Direction.DESC)
            Pageable pageable) {
        return scoreBoardService.findBySubjectId(subjectId, pageable);
    }

    // ── Không phân trang ──────────────────────────────────────────────

    @GetMapping("/api/v1/scoreboards")
    public List<ScoreBoardDto> findAll() {
        return scoreBoardService.findAll();
    }

    @GetMapping("/api/v1/scoreboards/{id}")
    public ScoreBoardDto findById(@PathVariable("id") Long id) {
        return scoreBoardService.findById(id);
    }

    @GetMapping("/api/v1/scoreboards/student/{studentId}")
    public List<ScoreBoardDto> findByStudentId(@PathVariable("studentId") Long studentId) {
        return scoreBoardService.findByStudentId(studentId);
    }

    @GetMapping("/api/v1/scoreboards/student/code/{idstudent}")
    public List<ScoreBoardDto> findByIdstudent(@PathVariable("idstudent") String idstudent) {
        return scoreBoardService.findByIdstudent(idstudent);
    }

    @GetMapping("/api/v1/scoreboards/subject/code/{idsubject}")
    public List<ScoreBoardDto> findByIdsubject(@PathVariable("idsubject") String idsubject) {
        return scoreBoardService.findByIdsubject(idsubject);
    }

    // ── Ghi ───────────────────────────────────────────────────────────

    @PostMapping("/api/v1/scoreboards")
    public ScoreBoardDto create(@RequestBody ScoreBoardCreateForm form) {
        return scoreBoardService.create(form);
    }

    @PutMapping("/api/v1/scoreboards/{id}")
    public ScoreBoardDto update(@RequestBody ScoreBoardUpdateForm form,
                                @PathVariable("id") Long id) {
        return scoreBoardService.update(id, form);
    }

    @DeleteMapping("/api/v1/scoreboards/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        scoreBoardService.deleteById(id);
    }
}
