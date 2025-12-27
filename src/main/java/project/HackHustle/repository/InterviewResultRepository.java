package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Interview;
import project.HackHustle.entity.InterviewResult;

import java.util.List;

public interface InterviewResultRepository  extends JpaRepository<InterviewResult,Long> {
    List<Interview> findByStudentId(Long studentId);
}
