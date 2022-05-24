package repository.impl;

import dao.impl.PassengerDaoImpl;
import entity.Passenger;
import repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

public class PassengerRepositoryImpl implements PassengerRepository {
    @Override
    public Optional<List<Passenger>> getAll() {
        return Optional.ofNullable(new PassengerDaoImpl().getAll());
    }
}
