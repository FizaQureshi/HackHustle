package project.HackHustle.mapper;

import project.HackHustle.dto.QuizBattleDto;
import project.HackHustle.entity.QuizBattle;
import project.HackHustle.entity.Student;
import project.HackHustle.repository.StudentRepository;

public class QuizBattleMapper {

    // Mapping entity -> DTO
    public static QuizBattleDto mapToQuizBattleDto(QuizBattle quizBattle) {
        return new QuizBattleDto(
                quizBattle.getQuizID(),
                quizBattle.getDate(),
                quizBattle.getStudent().getStudentId(),
                quizBattle.getQuizScore(),
                quizBattle.getStatus(),
                quizBattle.getSubjectName(),
                quizBattle.getBattleId()
        );
    }

    // Mapping DTO -> entity
    public static QuizBattle mapToQuizBattle(QuizBattleDto quizBattleDTO, StudentRepository studentRepository) {
        // Fetch Student entity from DB using studentID
        Student student = studentRepository.findById(quizBattleDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + quizBattleDTO.getStudentId()));

        QuizBattle quizBattle = new QuizBattle();
        quizBattle.setQuizID(quizBattleDTO.getQuizID());
        quizBattle.setDate(quizBattleDTO.getDate());
        quizBattle.setStudent(student); // set the Student entity
        quizBattle.setQuizScore(quizBattleDTO.getQuizScore());
        quizBattle.setStatus(quizBattleDTO.getStatus());
        quizBattle.setSubjectName(quizBattleDTO.getSubjectName());
        quizBattle.setBattleId(quizBattleDTO.getBattleId());

        return quizBattle;
    }
}
