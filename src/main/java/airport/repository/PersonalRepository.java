package airport.repository;

import airport.entity.Personal;
import airport.entity.PersonalInfo;

import java.util.List;
import java.util.Optional;

public interface PersonalRepository {
    Optional<List<Personal>> getAll();

    Personal add(Personal personal);

    Personal update(Personal personal);

    boolean delete(Personal personal);

    Personal get(int id);
}
