package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject,String> {
}
