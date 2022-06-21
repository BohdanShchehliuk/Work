package airport.repository;

import airport.entity.Passenger;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Configuration
public interface PassengerRepository extends JpaRepository <Passenger, Integer> {
Passenger findByPassport(String passport);

@Query("from Passenger p LEFT JOIN p.tickets t LEFT JOIN t.flightId f where f.flightNumb = ?1")
List<Passenger> getPassengerByFlightNumb (Integer flightNumb);

 }
