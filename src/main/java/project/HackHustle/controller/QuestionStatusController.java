package project.HackHustle.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.HackHustle.dto.QuestionStatusDto;
import project.HackHustle.service.QuestionStatusService;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/questionstatus")
public class QuestionStatusController {

    private final QuestionStatusService questionStatusService;

    @PostMapping
    public ResponseEntity<Void> updateStatus(@RequestBody QuestionStatusDto questionStatusDto)
    {
        questionStatusService.saveStatus(questionStatusDto);
        return ResponseEntity.ok().build();
    }
}
