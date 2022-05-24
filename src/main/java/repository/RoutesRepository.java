package repository;

import entity.Routes;

import java.util.List;
import java.util.Optional;

public interface RoutesRepository {
    Optional <List<Routes>> getAll();
}
