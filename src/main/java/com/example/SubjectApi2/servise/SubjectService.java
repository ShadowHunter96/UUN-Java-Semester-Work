package com.example.SubjectApi2.servise;

import com.example.SubjectApi2.factory.SubjectFactory;
import com.example.SubjectApi2.repository.SubjectRepository;
import com.example.SubjectApi2.subject.SubjectDto;
import com.example.SubjectApi2.subject.SubjectEntity;
import org.springframework.stereotype.Service;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 11:40
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private AresService aresService;

    public ResponseEntity<?> addSubjectByIco(String ico, String acronym, String description) {

        if (subjectRepository.existsByIco(ico)) {
            String alreadyExistsMessage = "Subject with ICO " + ico + " already exists.";
            return ResponseEntity.badRequest().body(alreadyExistsMessage);
        }

        try {
            SubjectDto subjectDto = aresService.searchEconomicSubject(ico);
            subjectDto.setAcronym(acronym);
            subjectDto.setDescription(description);
            SubjectEntity subjectEntity = new SubjectEntity();
            SubjectFactory.fillEntity(subjectEntity, subjectDto);

            subjectRepository.save(subjectEntity);
            return ResponseEntity.ok(SubjectFactory.fromEntity(subjectEntity));
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(404).body(errorMessage);
        }
    }

    public ResponseEntity<?> deleteSubject(Long id) {
        return subjectRepository.findById(id)
                .map(entity -> {
                    if (!entity.isDeleted()) {
                        entity.setDeleted(true);
                        subjectRepository.save(entity);
                        return ResponseEntity.ok().build();
                    }
                    return ResponseEntity.badRequest().body("Subject is already marked as deleted.");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> updateSubject(Long id, String acronym, String description) {
        return subjectRepository.findById(id).map(entity -> {
            entity.setAcronym(acronym);
            entity.setDescription(description);
            subjectRepository.save(entity);
            return ResponseEntity.ok(SubjectFactory.fromEntity(entity));
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<SubjectDto> getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .map(entity -> ResponseEntity.ok(SubjectFactory.fromEntity(entity)))
                .orElse(ResponseEntity.notFound().build());
    }




}