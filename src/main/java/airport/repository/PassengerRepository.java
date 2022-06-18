package airport.repository;

import airport.entity.Passenger;
import airport.entity.Ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
@Configuration
public interface PassengerRepository extends JpaRepository <Passenger, Integer> {
Passenger findByPassport(String passport);
 }
