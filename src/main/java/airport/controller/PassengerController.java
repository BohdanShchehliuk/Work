package airport.controller;

import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class PassengerController {
    private PassengerService passengerService;
    private ModelMapper mapToEntity;
    private ModelMapper mapToDTO;

    @PostMapping("/passenger/post/")
    public String savePassenger(@RequestBody PassengerDto passenger) {
        passengerService.addPassenger(mapToEntity.map(passenger, Passenger.class));
        return "You add a new passenger from Front End";
    }

    @GetMapping("/passenger/create/")
    public String create(String passengerName, String passengerSurname, String passengerPassport) {

        PassengerDto passengerDto = PassengerDto.builder()
                .name(passengerName)
                .surname(passengerSurname)
                .passport(passengerPassport)
                .build();
        return savePassenger(passengerDto);
    }

    @PostMapping("/passenger/delete/")
    public String deletePassenger(@RequestParam String passport) throws Exception {
        if (passengerService.delete(passport).equals("success"))
            return "You have deleted a passenger ";
        return "There is no such passenger";
    }

    @GetMapping("/passenger/getbypassport/")
    public Optional<PassengerDto> getByPassport(@RequestParam String passport) {
        Passenger passenger = passengerService.getPassengerByPassport(passport);
        return Optional.ofNullable(mapToDTO.map(passenger, PassengerDto.class));
    }

    @GetMapping("/passenger/allpassengerbyflightnumber/")
    public String getPassengerByFlightNumb(@RequestParam int flightNumb) {
        List<Passenger> list = passengerService.getPassengerByFlightNumb(flightNumb);
        return list.toString();
    }
}


