package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Student;

public interface StudentRepository extends JpaRepository<Student,String> {
}
