package com.example.SubjectApi2.controller;

import com.example.SubjectApi2.servise.SubjectService;
import com.example.SubjectApi2.subject.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}