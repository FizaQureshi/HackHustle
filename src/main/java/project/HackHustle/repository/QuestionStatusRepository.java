package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.QuestionStatus;
import project.HackHustle.entity.QuestionStatusKey;

public interface QuestionStatusRepository extends JpaRepository<QuestionStatus, QuestionStatusKey> {
}
