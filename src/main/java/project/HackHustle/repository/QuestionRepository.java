package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Question;

public interface QuestionRepository  extends JpaRepository<Question,String> {
}
