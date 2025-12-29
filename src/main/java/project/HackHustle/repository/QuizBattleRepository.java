package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.QuizBattle;
import java.util.List;

public interface QuizBattleRepository extends JpaRepository<QuizBattle, Long> {

    List<QuizBattle> findByStudent_StudentId(Long studentID);

    List<QuizBattle> findByBattleId(Long battleId);
}
