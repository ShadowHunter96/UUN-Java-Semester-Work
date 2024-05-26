package com.example.SubjectApi2.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 11:10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private Long id;
    private String ico;
    private String obchodniJmeno;
    private String acronym;
    private String description;
    private boolean deleted;

}
