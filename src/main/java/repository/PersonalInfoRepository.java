package repository;

import entity.Personal;

import java.util.List;
import java.util.Optional;

public interface PersonalInfoRepository {
    Optional<List<Personal>> getAll();
}
