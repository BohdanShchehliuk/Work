package airport.repository;


import airport.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findFlightByFlightNumb(int flight_numb);

    @Query("from Flight f where f.time > :startData and f.time < :finishData")
    List<Flight> getAllFlightsFromStartDataToFinishData(@Param("startData") LocalDateTime startData, @Param("finishData") LocalDateTime finishData);

}
