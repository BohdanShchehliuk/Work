package airport.service.impl;

import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.repository.PassengerRepository;
import airport.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    ModelMapper modelMapper;

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    //    @Override - кастомний мапер
//    public Optional<RequestPassengerDto> getPassengerByPassport(String passport) {
//           RequestPassengerDto requestPassengerDto=new RequestPassengerDto(); //- кастомний мапер
//            Passenger passenger = passengerRepository.getByPassport(passport).orElseThrow();
//       return  Optional.ofNullable(requestPassengerDto.fromPassengerToDTO(passenger));
//    }
    @Override // молдерний мапер
    public Passenger getPassengerByPassport(String passport) {
        Passenger passenger = passengerRepository.findByPassport(passport);
        return passenger;
    }

    @Override
    public PassengerDto byTicket(PassengerDto passengerDto, int flightId) {
        return null;
    }

    public String delete(String passport) throws Exception {
        try {
            passengerRepository.delete(passengerRepository.findAll().stream().filter(p -> p.getPassport().equals(passport)).findFirst().orElseThrow());
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
