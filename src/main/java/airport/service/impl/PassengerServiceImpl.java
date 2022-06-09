package airport.service.impl;

import airport.dao.impl.PassengerDaoImpl;
import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.repository.PassengerRepository;
import airport.repository.impl.PassengerRepositoryImpl;
import airport.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    PassengerRepository passengerRepository = new PassengerRepositoryImpl();
    ModelMapper modelMapper;

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.add(passenger);
    }

    @Override
    public List<Passenger> getAll() {
        return new PassengerDaoImpl().getAll();
    }

//    @Override - кастомний мапер
//    public Optional<RequestPassengerDto> getPassengerByPassport(String passport) {
//           RequestPassengerDto requestPassengerDto=new RequestPassengerDto(); //- кастомний мапер
//            Passenger passenger = passengerRepository.getByPassport(passport).orElseThrow();
//       return  Optional.ofNullable(requestPassengerDto.fromPassengerToDTO(passenger));
//    }
       @Override // молдерний мапер
   public PassengerDto getPassengerByPassport(String passport) {
               Passenger passenger = passengerRepository.getByPassport(passport).orElseThrow();
          return  modelMapper.map(passenger, PassengerDto.class);
    }

    @Override
    public PassengerDto byTicket(PassengerDto passengerDto, int flightId) {
       return null;
    }
}
