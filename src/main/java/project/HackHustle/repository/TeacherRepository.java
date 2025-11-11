package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
