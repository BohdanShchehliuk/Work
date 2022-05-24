package repository.impl;

import dao.impl.PersonalDaoImpl;
import entity.Personal;
import repository.PersonalRepository;

import java.util.List;
import java.util.Optional;

public class PersonalRepositoryImpl implements PersonalRepository {
    @Override
    public Optional<List<Personal>> getAll() {
        return Optional.ofNullable(new PersonalDaoImpl().getAll());
    }
}
