package airport.repository.impl;

import airport.dao.impl.PassengerDaoImpl;
import airport.entity.Passenger;
import airport.repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

public class PassengerRepositoryImpl implements PassengerRepository {
    @Override
    public Optional<List<Passenger>> getAll() {
        return Optional.ofNullable(new PassengerDaoImpl().getAll());
    }
}
