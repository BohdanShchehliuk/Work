package airport.repository;


import airport.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<Flight, Integer> {
  Flight findFlightByFlightNumb(int flight_numb);
    }
