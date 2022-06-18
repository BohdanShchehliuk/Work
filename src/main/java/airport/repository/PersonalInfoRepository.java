package airport.repository;

import airport.entity.Personal;
import airport.entity.PersonalInfo;

import java.util.List;
import java.util.Optional;

public interface PersonalInfoRepository {
    Optional<List<PersonalInfo>> getAll();
    PersonalInfo add(PersonalInfo personalInfo);
    PersonalInfo update(PersonalInfo personalInfo);
    boolean delete(PersonalInfo personalInfo);
    PersonalInfo get(int id);
}
