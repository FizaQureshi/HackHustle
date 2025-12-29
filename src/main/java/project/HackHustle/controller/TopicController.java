package project.HackHustle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.dto.TopicDto;
import project.HackHustle.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    //http://localhost:8080/api/topics/subject/1001
    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<TopicDto>> getTopicsBySubjectId(@PathVariable Long subjectId) {
        return ResponseEntity.ok(topicService.getTopicsBySubjectId(subjectId));
    }

    //http://localhost:8080/api/topics/subject/1001/count
    @GetMapping("/subject/{subjectId}/count")
    public ResponseEntity<Long> countTopicsBySubjectId(@PathVariable Long subjectId) {
        return ResponseEntity.ok(topicService.countTopicsBySubjectId(subjectId));
    }
}
