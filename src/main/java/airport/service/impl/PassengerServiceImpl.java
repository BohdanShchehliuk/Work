package airport.service.impl;

import airport.entity.Passenger;
import airport.repository.PassengerRepository;
import airport.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    public PassengerRepository passengerRepository;

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }


    @Override
    public Passenger getPassengerByPassport(String passport) {
        Passenger passenger = passengerRepository.findByPassport(passport);
        return passenger;
    }



    public String delete(String passport) throws Exception {
        try {
            passengerRepository.delete(passengerRepository.findAll()
                    .stream()
                    .filter(p -> p.getPassport().equals(passport))
                    .findFirst().orElseThrow());
            return "success";
        } catch (Exception exception) {
            return "absence";
        }
    }

    @Override

    public List<Passenger> getPassengerByFlightNumb(int flightNumb) {
        return passengerRepository.getPassengerByFlightNumb(flightNumb);
    }
}
