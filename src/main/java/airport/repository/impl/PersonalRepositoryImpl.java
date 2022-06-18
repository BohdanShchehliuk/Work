package airport.repository.impl;

import airport.dao.impl.PersonalDaoImpl;
import airport.entity.Personal;
import airport.repository.PersonalRepository;

import java.util.List;
import java.util.Optional;

public class PersonalRepositoryImpl implements PersonalRepository {
    @Override
    public Optional<List<Personal>> getAll() {
        return Optional.ofNullable(new PersonalDaoImpl().getAll());
    }

    @Override
    public Personal add(Personal personal) {
        return new PersonalDaoImpl().add(personal);
    }

    @Override
    public Personal update(Personal personal) {
        return new PersonalDaoImpl(). update(personal);
    }

    @Override
    public boolean delete(Personal personal) {
        return new PersonalDaoImpl().delete(personal);
    }

    @Override
    public Personal get(int id) {
        return new PersonalDaoImpl().get(id);
    }
}
