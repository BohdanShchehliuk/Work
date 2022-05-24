package service;

import dao.impl.FlightDaoImpl;
import entity.Flight;
import org.springframework.stereotype.Service;
import repository.FlightRepository;
import repository.impl.FlightRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository = new FlightRepositoryImpl();

    public Flight addFlight(Flight flight){
       return flightRepository.add(flight);
    }

    @Override
    public Optional<List<Flight>> getAll() {
        return Optional.ofNullable(new FlightDaoImpl().getAll());
    }
}
