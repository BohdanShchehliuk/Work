package airport.service;

import airport.dao.impl.FlightDaoImpl;
import airport.entity.Flight;
import org.springframework.stereotype.Service;
import airport.repository.FlightRepository;
import airport.repository.impl.FlightRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements airport.service.FlightService {
    FlightRepository flightRepository = new FlightRepositoryImpl();

    public Flight addFlight(Flight flight){
       return flightRepository.add(flight);
    }

    @Override
    public Optional<List<Flight>> getAll() {
        return Optional.ofNullable(new FlightDaoImpl().getAll());
    }
}
