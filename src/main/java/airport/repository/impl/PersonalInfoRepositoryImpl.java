package airport.repository.impl;

import airport.dao.impl.PersonalDaoImpl;
import airport.entity.Personal;
import airport.repository.PersonalRepository;

import java.util.List;
import java.util.Optional;

public class PersonalInfoRepositoryImpl implements PersonalRepository {
    @Override
    public Optional<List<Personal>> getAll() {
        return Optional.ofNullable(new PersonalDaoImpl().getAll());
    }
}
