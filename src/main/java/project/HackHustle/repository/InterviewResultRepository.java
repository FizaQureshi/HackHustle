package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.InterviewResult;

public interface InterviewResultRepository  extends JpaRepository<InterviewResult,String> {
}
