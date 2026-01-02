package project.HackHustle.service;

import project.HackHustle.dto.QuizBattleDto;

import java.util.List;

public interface QuizBattleService {

    QuizBattleDto saveQuizBattle(QuizBattleDto quizBattleDTO);

    void deleteQuizBattle(Long quizID);

    List<QuizBattleDto> getQuizBattlesByStudent(Long studentId);

    List<QuizBattleDto> getQuizBattlesByBattleId(String battleId);
}
