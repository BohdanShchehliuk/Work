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

    @Override
    public Routes add(Routes routes) {
        return new RoutesDaoImp().add(routes);
    }

    @Override
    public Routes update(Routes routes) {
        return new RoutesDaoImp().update(routes);
    }

    @Override
    public boolean delete(Routes routes) {
        return new RoutesDaoImp().delete(routes);
    }

    @Override
    public Routes get(int id) {
        return new RoutesDaoImp().get(id);
    }
}
