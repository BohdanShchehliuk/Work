package airport.service.impl;


import airport.entity.Flight;
import airport.exception.CustomException;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FlightServiceImpl implements airport.service.FlightService {
    private Session session;
    private ModelMapper mapperToDTO;

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) throws UserAlreadyExistException, CustomException {
        log.debug("Service / Flight addFlight/ started work");
        if (flight.getAircraft().equals(null) || flight.getTime().toLocalTime().isBefore(LocalDateTime.now().toLocalTime())) {
            throw new CustomException("Can't be added. Check crafts and time");
        }

        Optional<Flight> flight1 = Optional.ofNullable(flightRepository.findFlightByFlightNumb(flight.getFlightNumb()));
        if (!flight1.isEmpty()) {
            throw new UserAlreadyExistException(flight.getId(), "This flight is already existed");
        }
        return flightRepository.save(flight);
    }


    @Override
    public List<Flight> getAll() throws UserNotFoundException {
        log.info("Service /List<Flight> getAll()/ started work");
        List<Flight> list = flightRepository.findAll();
        if (list.isEmpty()) {
            throw new UserNotFoundException("Flights list is empty");
        }
        return list;
    }


    //Метод, який дозволяє шукати польоти між датами безпосередньо у БД
    @Override
    public List<Flight> getAllFlightsFromStartDataToFinishData(LocalDateTime startData, LocalDateTime finishData)
            throws UserNotFoundException, CustomException {
        log.info("Service /List<Flight> getAllFlightsFromStartDataToFinishData/ started work");
        List<Flight> list = flightRepository.getAllFlightsFromStartDataToFinishData(startData, finishData);
        if (startData.isAfter(finishData)) throw new CustomException("StartData is after FinishData");
        if (list.isEmpty()) {
            throw new UserNotFoundException("Flights list is empty");
        }
        return list;
    }

    @Override
    public Optional<Flight> findFlightByFlightNumb(int flight_numb) throws UserNotFoundException {
        log.info("Service /Flight findFlightByFlightNumb/ started work");
        Optional<Flight> flight = Optional.ofNullable(flightRepository.findFlightByFlightNumb(flight_numb));
        if (flight.isEmpty()) {
            throw new UserNotFoundException("This Flight numb " + flight_numb + " is absent");
        }
        return flight;
    }
}
