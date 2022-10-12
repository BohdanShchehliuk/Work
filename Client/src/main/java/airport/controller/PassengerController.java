package airport.controller;

import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PassengerController {
    final private PassengerService passengerService;
    final private ModelMapper mapToEntity;
    final private ModelMapper mapToDTO;
    static final String ANSI_RED = "\u001B[31m";

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
    public PassengerDto getByPassport(@RequestParam String passport) throws UserNotFoundException {
        log.info("Controller /passenger/getbypassport/ started work");
        Passenger passenger = passengerService.getPassengerByPassport(passport);
        return mapToDTO.map(passenger, PassengerDto.class);
    }

    @GetMapping("/passenger/allpassengerbyflightnumber/")
    public String getPassengerByFlightNumb(@RequestParam int flightNumb) throws UserNotFoundException {
        log.info("Controller /passenger/allpassengerbyflightnumber/ started work");
        return passengerService.getPassengerByFlightNumb(flightNumb).toString();
    }
}


