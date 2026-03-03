package project.HackHustle.mapper;

import project.HackHustle.dto.QuizBattleDto;
import project.HackHustle.entity.QuizBattle;
import project.HackHustle.entity.Student;
import project.HackHustle.entity.Subject;
import project.HackHustle.repository.StudentRepository;
import project.HackHustle.repository.SubjectRepository;

public class QuizBattleMapper {

    // Mapping entity -> DTO
    public static QuizBattleDto mapToQuizBattleDto(QuizBattle quizBattle) {
        return new QuizBattleDto(
                quizBattle.getQuizID(),
                quizBattle.getQuizNumber(),
                quizBattle.getPlayerNumber(),
                quizBattle.getStudent().getStudentId(),
                quizBattle.getQuizScore(),
                quizBattle.getStatus(),
                quizBattle.getBattleCode()
        );
    }

    // Mapping DTO -> entity
    public static QuizBattle mapToQuizBattle(
            QuizBattleDto quizBattleDTO,
            StudentRepository studentRepository) {

        // Fetch Student entity
        Student student = studentRepository.findById(quizBattleDTO.getStudentId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found with ID: "
                                + quizBattleDTO.getStudentId()));

        QuizBattle quizBattle = new QuizBattle();

        quizBattle.setQuizID(quizBattleDTO.getQuizID());
        quizBattle.setQuizNumber(quizBattleDTO.getQuizNumber());
        quizBattle.setPlayerNumber(quizBattleDTO.getPlayerNumber());
        quizBattle.setStudent(student);
        quizBattle.setQuizScore(quizBattleDTO.getQuizScore());
        quizBattle.setStatus(quizBattleDTO.getStatus());

        return quizBattle;
    }
}
