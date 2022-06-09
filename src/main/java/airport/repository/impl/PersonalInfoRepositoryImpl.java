package airport.repository.impl;

import airport.dao.impl.PersonalInfoDaoImpl;
import airport.entity.Personal;
import airport.entity.PersonalInfo;
import airport.repository.PersonalInfoRepository;

import java.util.List;
import java.util.Optional;

public class PersonalInfoRepositoryImpl implements PersonalInfoRepository {


    @Override
    public Optional<List<PersonalInfo>> getAll() {
        return Optional.ofNullable(new PersonalInfoDaoImpl().getAll());
    }

    @Override
    public PersonalInfo add(PersonalInfo personalInfo) {
        return new PersonalInfoDaoImpl().add(personalInfo);
    }

    @Override
    public PersonalInfo update(PersonalInfo personalInfo) {
        return new PersonalInfoDaoImpl().update(personalInfo);
    }

    @Override
    public boolean delete(PersonalInfo personalInfo) {
        return new PersonalInfoDaoImpl().delete(personalInfo);
    }

    @Override
    public PersonalInfo get(int id) {
        return new PersonalInfoDaoImpl().get(id);
    }

}

