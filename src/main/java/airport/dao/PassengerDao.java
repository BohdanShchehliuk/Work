package airport.dao;

import airport.entity.Passenger;

import java.util.Optional;

public interface PassengerDao extends GeneralDao <Passenger> {
    Optional<Passenger>getByIdWithTickets(int id);
    Optional<Passenger> getPassengerByPassport(String passport);

}
