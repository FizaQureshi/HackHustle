package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Interview;

public interface InterviewRepository  extends JpaRepository<Interview,Long> {
}
