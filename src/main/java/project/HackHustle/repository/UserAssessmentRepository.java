package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.UserAssessment;

public interface UserAssessmentRepository extends JpaRepository<UserAssessment,Long> {
}
