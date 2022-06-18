package airport.repository;

import airport.entity.Passenger;
import airport.entity.Terminal;
import airport.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
}
