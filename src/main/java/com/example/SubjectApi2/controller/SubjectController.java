package com.example.SubjectApi2.controller;

import com.example.SubjectApi2.servise.SubjectService;
import com.example.SubjectApi2.subject.SubjectDto;
import com.example.SubjectApi2.subject.SubjectFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 11:57
 */
@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/add")
    public ResponseEntity<?> addSubject(@RequestParam String ico, String acronym, String description) {
        return subjectService.addSubjectByIco(ico, acronym, description);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
        return subjectService.deleteSubject(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Long id, @RequestParam String acronym, @RequestParam(required = false) String description) {
        return subjectService.updateSubject(id, acronym, description);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<SubjectDto>> findSubjectPage(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "false") boolean deleted,
            @RequestParam(required = false, defaultValue = "id") String sortBy) {

        SubjectFilterDto filter = new SubjectFilterDto();
        filter.setPage(page);
        filter.setSize(size);
        filter.setDeleted(deleted);

        List<Sort.Order> orders = Collections.singletonList(Sort.Order.by(sortBy));
        filter.setOrderList(orders);

        Page<SubjectDto> result = subjectService.findSubjectPageDto(filter);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search2")
    public ResponseEntity<List<SubjectDto>> findSubjects(
            @RequestParam(required = false) Boolean deleted,
            @RequestParam String description,
            @RequestParam String ico,
            @RequestParam(required = false, defaultValue = "id") String sortBy) {

        SubjectFilterDto filter = new SubjectFilterDto();
        filter.setDeleted(deleted);
        filter.setDescription(description);
        filter.setIco(ico);

        List<Sort.Order> orders = Collections.singletonList(Sort.Order.by(sortBy));
        filter.setOrderList(orders);

        List<SubjectDto> result = subjectService.findSubjects(filter);
        return ResponseEntity.ok(result);
    }


}