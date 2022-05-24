package repository.impl;

import dao.impl.RoutesDaoImp;
import entity.Routes;
import repository.RoutesRepository;

import java.util.List;
import java.util.Optional;

public class RoutesRepositoryImpl implements RoutesRepository {
    @Override
    public Optional<List<Routes>> getAll() {
        return Optional.ofNullable(new RoutesDaoImp().getAll());
    }
}
