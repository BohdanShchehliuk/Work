package airport.repository;

import airport.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {
}
