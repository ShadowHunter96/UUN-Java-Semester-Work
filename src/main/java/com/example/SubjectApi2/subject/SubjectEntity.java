package com.example.SubjectApi2.subject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 11:35
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acronym;
    private String obchodniJmeno;
    private String ico;
    private String description;
    private boolean deleted;

}
