package project.HackHustle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.HackHustle.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,String> {
}
