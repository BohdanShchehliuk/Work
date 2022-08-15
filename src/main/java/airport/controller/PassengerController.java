package airport.controller;

import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.exception.CustomException;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.service.PassengerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
public class PassengerController {
    private PassengerService passengerService;
    private ModelMapper mapToEntity;
    private ModelMapper mapToDTO;
    public static final String ANSI_RED = "\u001B[31m";

    @PostMapping("/passenger/post/")
    public String savePassenger(@RequestBody PassengerDto passenger) throws UserAlreadyExistException {
        log.info("Controller /passenger/post/ started work");
        passengerService.addPassenger(mapToEntity.map(passenger, Passenger.class));
        return "You add a new passenger from Front End";
    }

    @GetMapping("/passenger/create/")
    public String create(String passengerName, String passengerSurname, String passengerPassport) throws UserAlreadyExistException {
        log.info("Controller /passenger/create/ started work");
        PassengerDto passengerDto = PassengerDto.builder()
                .name(passengerName)
                .surname(passengerSurname)
                .passport(passengerPassport)
                .build();
        return savePassenger(passengerDto);
    }

    @PostMapping("/passenger/delete/")
    public String deletePassenger(@RequestParam String passport) throws Exception {
        log.info("Controller /passenger/delete/ started work");
        passengerService.delete(passport);
        return "You have deleted a passenger ";
    }

    @GetMapping("/passenger/getbypassport/")
    public Optional<PassengerDto> getByPassport(@RequestParam String passport) throws UserNotFoundException {
        log.info("Controller /passenger/getbypassport/ started work");
        Passenger passenger = passengerService.getPassengerByPassport(passport);
        return Optional.ofNullable(mapToDTO.map(passenger, PassengerDto.class));
    }

    @GetMapping("/passenger/allpassengerbyflightnumber/")
    public String getPassengerByFlightNumb(@RequestParam int flightNumb) throws UserNotFoundException {
        log.info("Controller /passenger/allpassengerbyflightnumber/ started work");
        if (flightNumb <= 0) throw new CustomException("Type flight_number again");
        List<Passenger> list = passengerService.getPassengerByFlightNumb(flightNumb);
        return list.toString();
    }
}


