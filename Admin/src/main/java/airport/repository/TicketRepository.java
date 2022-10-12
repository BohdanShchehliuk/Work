package airport.repository;

import airport.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("from Ticket t LEFT JOIN FETCH t.flightId f where f.flightNumb =?1")
    List<Ticket> findTicketsByFlightNumb(int flightNumb);
}
