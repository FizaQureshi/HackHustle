package project.HackHustle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.HackHustle.dto.QuestionDto;
import project.HackHustle.repository.QuestionRepository;
import project.HackHustle.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/topic/{topicName}")
    public ResponseEntity<List<QuestionDto>>  getQuestionByTopic(@PathVariable String topicName)
    {
        List<QuestionDto> list = questionService.getQuestionByTopic(topicName);
        //if with this topic there exist no questions
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/subject/{subjectID}")
    public ResponseEntity<List<QuestionDto>>  getQuestionBySubject (@PathVariable Long subjectID)
    {
        List<QuestionDto> list = questionService.getQuestionBySubject(subjectID);
        //if with this topic there exist no questions
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }
}
