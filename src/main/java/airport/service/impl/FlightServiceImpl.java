package airport.service.impl;

import airport.dao.impl.FlightDaoImpl;
import airport.dto.FlightDto;
import airport.entity.Flight;
import airport.repository.impl.FlightRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import airport.repository.FlightRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements airport.service.FlightService {
    ModelMapper modelMapper = new ModelMapper();
    FlightRepository flightRepository = new FlightRepositoryImpl();

    public Flight addFlight(Flight flight) {
        return flightRepository.add(flight);
    }

    @Override
    public List<Flight> getAll() {
        return new FlightDaoImpl().getAll();
    }

    @Override
    public List<FlightDto> getAllFomDataAtoDataB(LocalDate startData, LocalDate finishData) {
        return getAll().stream().
                filter(flight -> flight.getTime().toLocalDate().isAfter(startData) &&
                        flight.getTime().toLocalDate().isBefore(finishData))
                .map(flight -> modelMapper
                        .map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }
}

