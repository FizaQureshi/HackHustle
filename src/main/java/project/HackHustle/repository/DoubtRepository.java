package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Doubt;

public interface DoubtRepository extends JpaRepository<Doubt,String> {

}
