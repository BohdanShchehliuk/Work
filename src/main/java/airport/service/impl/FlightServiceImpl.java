package airport.service.impl;

import airport.dto.FlightDto;
import airport.entity.Flight;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import airport.repository.FlightRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements airport.service.FlightService {
    private Session session;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
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

    @Override
    public Flight findFlightByFlightNumb(int flight_numb) {
        return flightRepository.findFlightByFlightNumb(flight_numb);
    }
}

//    Date dateOne = Date.from(startData.atStartOfDay(ZoneId.systemDefault()).toInstant());
//    Date dateTwo = Date.from(startData.atStartOfDay(ZoneId.systemDefault()).toInstant());
//
//    NativeQuery query = (NativeQuery) session.createQuery("\"from Flight f where f.time > ?"+dateOne+" and " +
//            "f.time < ?"+dateTwo+"\"");
//    List<FlightDto> list = query.list();