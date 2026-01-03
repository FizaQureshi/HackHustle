package project.HackHustle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.QuizBattleDto;
import project.HackHustle.entity.QuizBattle;
import project.HackHustle.entity.Student;
import project.HackHustle.mapper.QuizBattleMapper;
import project.HackHustle.repository.QuizBattleRepository;
import project.HackHustle.repository.StudentRepository;
import project.HackHustle.repository.SubjectRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizBattleServiceImpl implements QuizBattleService {

    private final QuizBattleRepository quizBattleRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public QuizBattleDto saveQuizBattle(QuizBattleDto quizBattleDTO) {

        QuizBattle quizBattle = QuizBattleMapper.mapToQuizBattle(quizBattleDTO, studentRepository, subjectRepository);

        //quizBattle.setDate(LocalDateTime.now());

        QuizBattle savedQuizBattle = quizBattleRepository.save(quizBattle);

        return QuizBattleMapper.mapToQuizBattleDto(savedQuizBattle);
    }

    @Override
    public void deleteQuizBattle(Long quizID) {
        quizBattleRepository.deleteById(quizID);
    }

    @Override
    public List<QuizBattleDto> getQuizBattlesByStudent(Long studentId) {

        List<QuizBattle> battles = quizBattleRepository.findByStudent_StudentId(studentId);

        return battles.stream()
                .map(QuizBattleMapper::mapToQuizBattleDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuizBattleDto> getQuizBattlesByBattleId(String battleId) {
        List<QuizBattle> battles = quizBattleRepository.findByBattleId(battleId);

        return battles.stream()
                .map(QuizBattleMapper::mapToQuizBattleDto)
                .collect(Collectors.toList());
    }
}
