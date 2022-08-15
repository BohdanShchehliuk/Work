package airport.service.impl;

import airport.entity.Flight;
import airport.entity.Passenger;
import airport.exception.CustomException;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.repository.PassengerRepository;
import airport.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    public PassengerRepository passengerRepository;
    @Autowired
    public FlightServiceImpl flightService;

    @Override
    public Passenger addPassenger(Passenger passenger) throws UserAlreadyExistException {
        log.info("Service / Passenger addPassenger/ started work");
Optional <String> passport = Optional.ofNullable(passenger.getPassport());
        if (passport.isEmpty())
            throw new CustomException("Check Passport");
        if (!passengerRepository.findAll()
                .stream()
                .filter(p -> p.getPassport().equals(passenger.getPassport())
                        && p.getSurname().equals(passenger.getSurname()))
                .findFirst().isEmpty())
            throw new UserAlreadyExistException(passenger.getId(), "Passenger " + passenger.getSurname()+" already exists");
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAll() throws UserNotFoundException {
        log.info("Service /List<Passenger> getAll()/ started work");
        List<Passenger> list = passengerRepository.findAll();
        if (list.isEmpty()) throw new UserNotFoundException("List of Passengers is empty");
        return list;
    }


    @Override
    public Passenger getPassengerByPassport(String passport) throws UserNotFoundException {
        log.info("Service /Passenger getPassengerByPassport(String passport)/ started work");
        Optional<Passenger> passenger = Optional.ofNullable(passengerRepository.findByPassport(passport));
        if (passenger.isEmpty()) throw new UserNotFoundException("Passenger with passport " + passport + "is absent");
        return passenger.get();
    }

    public String delete(String passport) throws UserNotFoundException {
        log.info("Service /String delete (String passport)/ started work");
        if (passengerRepository.findAll()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst().isEmpty()) throw new UserNotFoundException("Passenger with such passport dose not exist");
        passengerRepository.delete(passengerRepository.findByPassport(passport));
        return "Passenger successfully deleted";

    }

    @Override
    public List<Passenger> getPassengerByFlightNumb(int flightNumb) throws UserNotFoundException {
        log.info("Service /List<Passenger> getPassengerByFlightNumb/ started work");
        flightService.findFlightByFlightNumb(flightNumb);
        List<Passenger> list = passengerRepository.getPassengerByFlightNumb(flightNumb);
        if (list.isEmpty())
            throw new UserNotFoundException("There are no passengers in Flight with flight_number " + flightNumb);
        return list;
    }
}
