package com.ted.Backend.Controller;

import com.ted.Backend.Dto.SubjectDto;
import com.ted.Backend.Form.SubjectCreateForm;
import com.ted.Backend.Form.SubjectUpdateForm;
import com.ted.Backend.Service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SubjectController {

    private SubjectService subjectService;


    @GetMapping("/api/v1/subjects/page")
    public Page<SubjectDto> findAllPage(
            @PageableDefault(size = 10, sort = "subjectname", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return subjectService.findAll(pageable);
    }

    @GetMapping("/api/v1/subjects/page/search")
    public Page<SubjectDto> searchByNamePage(
            @RequestParam("name") String name,
            @PageableDefault(size = 10, sort = "subjectname", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return subjectService.findByName(name, pageable);
    }


    @GetMapping("/api/v1/subjects")
    public List<SubjectDto> findAll() {
        return subjectService.findAll();
    }

    @GetMapping("/api/v1/subjects/{id}")
    public SubjectDto findById(@PathVariable("id") Long id) {
        return subjectService.findById(id);
    }

    @GetMapping("/api/v1/subjects/code/{idsubject}")
    public SubjectDto findByIdsubject(@PathVariable("idsubject") String idsubject) {
        return subjectService.findByIdsubject(idsubject);
    }

    @GetMapping("/api/v1/subjects/search")
    public List<SubjectDto> searchByName(@RequestParam("name") String name) {
        return subjectService.findByName(name);
    }

    // ── Ghi ───────────────────────────────────────────────────────────

    @PostMapping("/api/v1/subjects")
    public SubjectDto create(@RequestBody SubjectCreateForm form) {
        return subjectService.create(form);
    }

    @PutMapping("/api/v1/subjects/{id}")
    public SubjectDto update(@RequestBody SubjectUpdateForm form,
                             @PathVariable("id") Long id) {
        return subjectService.update(id, form);
    }

    @DeleteMapping("/api/v1/subjects/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        subjectService.deleteById(id);
    }
}
