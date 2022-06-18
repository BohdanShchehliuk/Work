package airport.repository;

import airport.entity.Personal;
import airport.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalInfoRepository extends JpaRepository <Personal, Integer> {
    }
