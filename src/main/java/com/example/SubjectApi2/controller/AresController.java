package com.example.SubjectApi2.controller;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 10:15
 */
import com.example.SubjectApi2.servise.AresService;
import com.example.SubjectApi2.subject.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ares")
public class AresController {

    @Autowired
    private AresService aresService;

    @PostMapping("/subject")
    public SubjectDto getEconomicSubject(@RequestParam String ico) {
        return aresService.searchEconomicSubject(ico);
    }
}