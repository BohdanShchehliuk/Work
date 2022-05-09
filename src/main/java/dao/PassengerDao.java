package dao;

import entity.Passenger;

import java.util.Optional;

public interface PassengerDao extends GeneralDao <Passenger> {
    Optional<Passenger>getByIdWithTickets(int id);
}
