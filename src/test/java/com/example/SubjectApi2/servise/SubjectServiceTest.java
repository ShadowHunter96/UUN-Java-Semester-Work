package com.example.SubjectApi2.servise;


import com.example.SubjectApi2.factory.SubjectFactory;
import com.example.SubjectApi2.repository.SubjectRepository;
import com.example.SubjectApi2.subject.SubjectDto;
import com.example.SubjectApi2.subject.SubjectEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private AresService aresService;

    @InjectMocks
    private SubjectService subjectService;

    @Test
    public void testAddSubjectByIcoAlreadyExists() {
        when(subjectRepository.existsByIco(anyString())).thenReturn(true);

        ResponseEntity<?> response = subjectService.addSubjectByIco("123456789", "FA", "Description of FA");

        assertEquals(400, response.getStatusCodeValue());
        verify(subjectRepository, never()).save(any(SubjectEntity.class));
    }

    @Test
    public void testAddSubjectByIcoNew() {
        when(subjectRepository.existsByIco(anyString())).thenReturn(false);
        when(aresService.searchEconomicSubject(anyString())).thenReturn(new SubjectDto());
        when(subjectRepository.save(any(SubjectEntity.class))).thenReturn(new SubjectEntity());

        ResponseEntity<?> response = subjectService.addSubjectByIco("123456789", "FA", "Description of FA");

        assertEquals(200, response.getStatusCodeValue());
        verify(subjectRepository).save(any(SubjectEntity.class));
    }

    @Test
    public void testDeleteSubjectNotFound() {
        when(subjectRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<?> response = subjectService.deleteSubject(1L);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteSubjectFound() {
        SubjectEntity entity = new SubjectEntity();
        when(subjectRepository.findById(anyLong())).thenReturn(Optional.of(entity));

        ResponseEntity<?> response = subjectService.deleteSubject(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(entity.isDeleted());
        verify(subjectRepository).save(entity);
    }

    @Test
    public void testUpdateSubjectNotFound() {
        when(subjectRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<?> response = subjectService.updateSubject(1L, "UpdatedAcronym", "UpdatedDescription");

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateSubjectFound() {
        SubjectEntity entity = new SubjectEntity();
        when(subjectRepository.findById(anyLong())).thenReturn(Optional.of(entity));

        ResponseEntity<?> response = subjectService.updateSubject(1L, "UpdatedAcronym", "UpdatedDescription");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("UpdatedAcronym", entity.getAcronym());
        assertEquals("UpdatedDescription", entity.getDescription());
        verify(subjectRepository).save(entity);
    }

    @Test
    public void testGetSubjectByIdNotFound() {
        when(subjectRepository.findById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<?> response = subjectService.getSubjectById(1L);

        assertEquals(404, response.getStatusCodeValue());
    }

}