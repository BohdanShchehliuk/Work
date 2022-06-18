package airport.repository.impl;

import airport.dao.impl.PassengerDaoImpl;
import airport.entity.Passenger;
import airport.repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

public class PassengerRepositoryImpl implements PassengerRepository {
    public PassengerRepositoryImpl() {
    }

    @Override
    public List<Passenger> getAll() {
        return new PassengerDaoImpl().getAll();
    }

    @Override
    public Passenger add(Passenger passenger) {
        return new PassengerDaoImpl().add(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return new PassengerDaoImpl().update(passenger);
    }

    @Override
    public boolean delete(Passenger passenger) {
        return new PassengerDaoImpl().delete(passenger);
    }

    @Override
    public Passenger get(int id) {
        return new PassengerDaoImpl().get(id);
    }

    @Override
    public Optional <Passenger> getByPassport(String passport) {
        return new PassengerDaoImpl().getPassengerByPassport(passport);
    }
}
