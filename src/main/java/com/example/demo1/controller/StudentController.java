package com.example.demo1.controller;

import com.example.demo1.usecases.StudentsCsvUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    private final StudentsCsvUseCase studentsCsvUseCase;

    @Autowired
    public StudentController(StudentsCsvUseCase studentsCsvUseCase) {
        this.studentsCsvUseCase = studentsCsvUseCase;
    }

    @GetMapping(path = "/students")
    public ResponseEntity getStudentsAsCsv() {

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=students.csv")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(studentsCsvUseCase.getStudentsAsCsv());
    }

    @GetMapping(path = "/courses")
    public ResponseEntity getStudentsAsCsvByCourse() {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=course.csv")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(studentsCsvUseCase.getStudentsAsCsvByCourse());
    }
}