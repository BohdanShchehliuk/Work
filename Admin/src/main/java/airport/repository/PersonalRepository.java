package airport.repository;

import airport.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalRepository extends JpaRepository<Personal, Integer> {
    Personal findByName(String name);

    Personal findByNumbPhone(int numbPhone);

    @Query("from Personal p LEFT JOIN p.gate g where g.numberofgate  = ?1")
    List<Personal> getPersonalByGate(Integer numberofgate);
}
