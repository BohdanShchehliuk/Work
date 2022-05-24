package airport.repository.impl;

import airport.dao.impl.RoutesDaoImp;
import airport.entity.Routes;
import airport.repository.RoutesRepository;

import java.util.List;
import java.util.Optional;

public class RoutesRepositoryImpl implements RoutesRepository {
    @Override
    public Optional<List<Routes>> getAll() {
        return Optional.ofNullable(new RoutesDaoImp().getAll());
    }
}
