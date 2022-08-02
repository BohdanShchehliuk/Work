package airport.service.impl;

import airport.entity.Passenger;
import airport.exception.CustomException;
import airport.repository.PassengerRepository;
import airport.service.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    private static final Logger LOG = LoggerFactory.getLogger( PassengerServiceImpl.class);
    public static final String ANSI_RED = "\u001B[31m";

    @Autowired
    public PassengerRepository passengerRepository;

    @Override
    public Passenger addPassenger(Passenger passenger) {
        LOG.debug("Service / Passenger addPassenger/ " +
                "started work");
        try {
            return passengerRepository.save(passenger);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + " passengerRepository.save(passenger)  does not answer");
            throw new CustomException(" passengerRepository.save(passenger)", " is not correct");
        }
    }

    @Override
    public List<Passenger> getAll() {
        LOG.debug("Service /List<Passenger> getAll()/ started work");
        try {
            return passengerRepository.findAll();
        } catch (Exception exception) {
            LOG.error(ANSI_RED + " passengerRepository.findAll()  does not answer");
            throw new CustomException(" passengerRepository.findAll()", " is not correct");
        }
    }


    @Override
    public Passenger getPassengerByPassport(String passport) {
        LOG.debug("Service /Passenger getPassengerByPassport(String passport)/ started work");
        try {
            return passengerRepository.findByPassport(passport);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "passengerRepository.findByPassport(passport)  does not answer");
            throw new CustomException(" passengerRepository.findByPassport(passport)", " is not correct");
        }
    }

    public String delete(String passport) throws Exception {
        LOG.debug("Service /String delete (String passport)/ started work");
        try {
            passengerRepository.delete(passengerRepository.findAll()
                    .stream()
                    .filter(p -> p.getPassport().equals(passport))
                    .findFirst().orElseThrow());
            return "success";
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "String delete (String passport) has a problem. Maybe there is no passenger with such passport");
            return "absence";
        }
    }

    @Override
    public List<Passenger> getPassengerByFlightNumb(int flightNumb) {
        LOG.debug("Service /List<Passenger> getPassengerByFlightNumb/ started work");
        try {
            return passengerRepository.getPassengerByFlightNumb(flightNumb);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "String delete (String passport) has a problem. Maybe there is no passenger with such passport");
            throw new CustomException(" passengerRepository.findByPassport(passport)", " is not correct");
        }
    }
}
