package com.example.SubjectApi2.subject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 20:13
 */
@Getter
@Setter
public class SubjectFilterDto {
    private String obchodniJmeno;
    private String description;
    private String acronym;
    private boolean deleted;


    private int page;
    private int size;
    private List<Sort.Order> orderList;
}
