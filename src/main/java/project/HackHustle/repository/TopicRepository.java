package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic,String> {
}
