package repository;

import entity.Personal;

import java.util.List;
import java.util.Optional;

public interface PersonalRepository {
    Optional<List<Personal>> getAll();
}
