package airport.service.impl;


import airport.controller.PassengerController;
import airport.entity.Flight;

import airport.exception.CustomException;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import airport.repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class FlightServiceImpl implements airport.service.FlightService {
    private Session session;
    private ModelMapper mapperToDTO = new ModelMapper();
    private static final Logger LOG = LoggerFactory.getLogger(FlightServiceImpl.class);
    public static final String ANSI_RED = "\u001B[31m";

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        LOG.debug("Service / Flight addFlight/ started work");
        try {
            return flightRepository.save(flight);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + " flightRepository.save(flight)  does not answer");
            throw new CustomException(" flightRepository.save(flight)", " is not correct");
        }
    }

    @Override
    public List<Flight> getAll() {
        LOG.debug("Service /List<Flight> getAll()/ started work");
        try {
            return flightRepository.findAll();
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "flightRepository.findAll()  does not answer");
            throw new CustomException("flightRepository.findAll()", " is not correct");
        }
    }

    //Метод, який дозволяє шукати польоти між датами безпосередньо у БД
    @Override
    public List<Flight> getAllFlightsFromStartDataToFinishData(LocalDateTime startData, LocalDateTime finishData) {
        LOG.debug("Service /List<Flight> getAllFlightsFromStartDataToFinishData/ started work");
        try {
            return flightRepository.getAllFlightsFromStartDataToFinishData(startData, finishData);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "List<Flight> getAllFlightsFromStartDataToFinishData/  does not answer");
            throw new CustomException("flightRepository.getAllFlightsFromStartDataToFinishData", " is not correct");
        }
    }

    @Override
    public Flight findFlightByFlightNumb(int flight_numb) {
        LOG.debug("Service /Flight findFlightByFlightNumb/ started work");
        try {
            return flightRepository.findFlightByFlightNumb(flight_numb);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Flight findFlightByFlightNumb/  does not answer");
            throw new CustomException("flightRepository.findFlightByFlightNumb", " is not correct");
        }
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
