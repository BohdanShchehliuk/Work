package airport.repository;

import airport.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<Personal, Integer> {
}
