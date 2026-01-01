package project.HackHustle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.QuizBattleDto;
import project.HackHustle.entity.QuizBattle;
import project.HackHustle.entity.Student;
import project.HackHustle.mapper.QuizBattleMapper;
import project.HackHustle.repository.QuizBattleRepository;
import project.HackHustle.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizBattleServiceImpl implements QuizBattleService {

    private final QuizBattleRepository quizBattleRepository;
    private final StudentRepository studentRepository;

    @Override
    public QuizBattleDto saveQuizBattle(QuizBattleDto quizBattleDTO) {

        QuizBattle quizBattle = QuizBattleMapper.mapToQuizBattle(quizBattleDTO, studentRepository);

        quizBattle.setDate(LocalDateTime.now());

        QuizBattle savedQuizBattle = quizBattleRepository.save(quizBattle);

        return QuizBattleMapper.mapToQuizBattleDto(savedQuizBattle);
    }

    @Override
    public void deleteQuizBattle(Long quizID) {
        quizBattleRepository.deleteById(quizID);
    }

    @Override
    public List<QuizBattleDto> getQuizBattlesByStudent(Long studentID) {

        List<QuizBattle> battles = quizBattleRepository.findByStudent_StudentId(studentID);

        return battles.stream()
                .map(QuizBattleMapper::mapToQuizBattleDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuizBattleDto> getQuizBattlesByBattleId(Long battleId) {
        List<QuizBattle> battles = quizBattleRepository.findByBattleId(battleId);

        return battles.stream()
                .map(QuizBattleMapper::mapToQuizBattleDto)
                .collect(Collectors.toList());
    }
}
