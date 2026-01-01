package project.HackHustle.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.dto.QuestionStatusDto;
import project.HackHustle.entity.Question;
import project.HackHustle.entity.QuestionStatus;
import project.HackHustle.entity.QuestionStatusKey;
import project.HackHustle.entity.Student;
import project.HackHustle.repository.QuestionRepository;
import project.HackHustle.repository.QuestionStatusRepository;
import project.HackHustle.repository.StudentRepository;
import project.HackHustle.service.QuestionStatusService;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/questionstatus")
public class QuestionStatusController {

    private final QuestionStatusService questionStatusService;
    private final QuestionStatusRepository questionStatusRepository;
    private final QuestionRepository questionRepository;
    private final StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Void> saveStatus(@RequestBody QuestionStatusKey key) {
        Student student = studentRepository.findById(key.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Question question = questionRepository.findById(key.getQuestionID())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        QuestionStatus qs = new QuestionStatus();
        qs.setId(key);
        qs.setStudent(student);
        qs.setQuestion(question);
        qs.setStatus("true");

        questionStatusRepository.save(qs);
        return ResponseEntity.ok().build();
    }
}
