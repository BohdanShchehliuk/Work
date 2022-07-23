package airport.service.impl;


import airport.entity.Flight;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import airport.repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class FlightServiceImpl implements airport.service.FlightService {
    private Session session;
    private ModelMapper mapperToDTO = new ModelMapper();
    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    //Метод, який дозволяє шукати польоти між датами безпосередньо у БД
    @Override
    public List<Flight> getAllFlightsFromStartDataToFinishData(LocalDateTime startData, LocalDateTime finishData) {
        return flightRepository.getAllFlightsFromStartDataToFinishData(startData, finishData);
    }

    @Override
    public Flight findFlightByFlightNumb(int flight_numb) {
        return flightRepository.findFlightByFlightNumb(flight_numb);
    }
}
//Метод, який дозволяє шукати польоти між датами через програму (не через БД)
// public List<Flight> getAllFlightsFromStartDataToFinishData(LocalDateTime startData, LocalDateTime finishData) {
//      return flightRepository.getAllFlightsFromStartDataToFinishData(startData, finishData);
//                getAll().stream().
//                filter(flight -> flight.getTime().toLocalDate().isAfter(startData) &&
//                        flight.getTime().toLocalDate().isBefore(finishData))
//                .map(flight -> mapperToDTO
//                        .map(flight, FlightDto.class))
//                .collect(Collectors.toList());
