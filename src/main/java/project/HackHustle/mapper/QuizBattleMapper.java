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
                quizBattle.getDate(),
                quizBattle.getStudent().getStudentId(),
                quizBattle.getQuizScore(),
                quizBattle.getStatus(),
                quizBattle.getSubject().getSubjectID(),
                quizBattle.getBattleId()
        );
    }

    // Mapping DTO -> entity
    public static QuizBattle mapToQuizBattle(QuizBattleDto quizBattleDTO, StudentRepository studentRepository, SubjectRepository subjectRepository) {

        // Fetch Student entity from DB using studentID and Subject using subjectId
        Student student = studentRepository.findById(quizBattleDTO.getStudentId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found with ID: " + quizBattleDTO.getStudentId()));

        Subject subject = subjectRepository.findById(quizBattleDTO.getSubjectId())
                .orElseThrow(() ->
                        new RuntimeException("Subject not found with ID: " + quizBattleDTO.getSubjectId()));

        QuizBattle quizBattle = new QuizBattle();
        quizBattle.setQuizID(quizBattleDTO.getQuizID());
        quizBattle.setDate(quizBattleDTO.getDate());
        quizBattle.setStudent(student); // set the Student entity
        quizBattle.setQuizScore(quizBattleDTO.getQuizScore());
        quizBattle.setStatus(quizBattleDTO.getStatus());
        quizBattle.setSubject(subject);
        quizBattle.setBattleId(quizBattleDTO.getBattleId());

        return quizBattle;
    }
}
