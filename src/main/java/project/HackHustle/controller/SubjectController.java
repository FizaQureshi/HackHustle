package project.HackHustle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.dto.SubjectDto;
import project.HackHustle.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    //http://localhost:8080/api/subjects
    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    //http://localhost:8080/api/subjects/1001
    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable Long subjectId) {
        return ResponseEntity.ok(subjectService.getSubjectById(subjectId));
    }
}
