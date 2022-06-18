package airport.repository;

import airport.entity.Passenger;
import airport.entity.Ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;
@Configuration
public interface PassengerRepository {
   List <Passenger> getAll();
    Passenger add(Passenger passenger);
    Passenger update(Passenger passenger);
    boolean delete(Passenger passenger);
    Passenger get(int id);
    Optional <Passenger> getByPassport(String passport);
}
