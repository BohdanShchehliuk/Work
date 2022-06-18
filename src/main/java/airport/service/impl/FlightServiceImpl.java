package airport.service.impl;

import airport.dto.FlightDto;
import airport.entity.Flight;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import airport.repository.FlightRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class FlightServiceImpl implements airport.service.FlightService {
    ModelMapper modelMapper = new ModelMapper();
  @Autowired
    FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        System.out.println("Lalala"+ flight.getAircraft().getAircraftTypes());
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
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
