package project.HackHustle.mapper;

import project.HackHustle.dto.QuizBattleDto;
import project.HackHustle.entity.QuizBattle;

public class QuizBattleMapper {

    public static QuizBattleDto mapToQuizBattleDto(QuizBattle quizBattle) {
        return new QuizBattleDto(
                quizBattle.getQuizID(),
                quizBattle.getDate(),
                quizBattle.getStudentID(),
                quizBattle.getQuizScore(),
                quizBattle.getStatus(),
                quizBattle.getSubjectName(),
                quizBattle.getBattleId()
        );
    }

    public static QuizBattle mapToQuizBattle(QuizBattleDto quizBattleDTO) {
        return new QuizBattle(
                quizBattleDTO.getQuizID(),
                quizBattleDTO.getDate(),
                quizBattleDTO.getStudentID(),
                quizBattleDTO.getQuizScore(),
                quizBattleDTO.getStatus(),
                quizBattleDTO.getSubjectName(),
                quizBattleDTO.getBattleId()
        );
    }
}
