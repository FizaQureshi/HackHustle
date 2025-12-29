package  project.HackHustle.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  project.HackHustle.dto.QuizBattleDto;
import project.HackHustle.service.QuizBattleService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/quiz-battles")
public class QuizBattleController {

    private final QuizBattleService quizBattleService;

    //http://localhost:8080/api/quiz-battles
    @PostMapping
    public ResponseEntity<QuizBattleDto> createQuizBattle(@RequestBody QuizBattleDto quizBattleDTO)
    {
        QuizBattleDto savedQuizBattle = quizBattleService.saveQuizBattle(quizBattleDTO);
        return new ResponseEntity<>(savedQuizBattle, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/quiz-battles/student/1001
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<QuizBattleDto>> getQuizBattlesByStudent(@PathVariable("studentId") Long studentId)
    {
        List<QuizBattleDto> battles = quizBattleService.getQuizBattlesByStudent(studentId);
        return new ResponseEntity<>(battles, HttpStatus.OK);
    }

    //http://localhost:8080/api/quiz-battles/battle/2001
    @GetMapping("/battle/{battleId}")
    public ResponseEntity<List<QuizBattleDto>> getQuizBattlesByBattleId(@PathVariable("battleId") Long battleId)
    {
        List<QuizBattleDto> battles = quizBattleService.getQuizBattlesByBattleId(battleId);
        return new ResponseEntity<>(battles, HttpStatus.OK);
    }

    //http://localhost:8080/api/quiz-battles/3001
    @DeleteMapping("{quizId}")
    public ResponseEntity<String> deleteQuizBattle(@PathVariable("quizId") Long quizId)
    {
        quizBattleService.deleteQuizBattle(quizId);
        return ResponseEntity.ok("QuizBattle deleted successfully");
    }
}
