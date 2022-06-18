package airport.controller;

import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.repository.PassengerRepository;
import airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class PassengerController {
    PassengerRepository passengerRepository;
   @Autowired
    public PassengerService passengerService;
    ModelMapper modelMapper;

    @PostMapping("/passenger/post/")
    public String savePassenger(@RequestBody PassengerDto passenger) {
        passengerService.addPassenger(modelMapper.map(passenger, Passenger.class));
        return "You add a new passenger from Front End";
    }

    @GetMapping("/passenger/create/")
    public PassengerDto create() {

        return PassengerDto.builder()
                .name("Chak")
                .surname("Noris")
                .passport("s2134")
                .build();

    }

    @PostMapping("/passenger/delete/")
    public String deletePassenger(@RequestParam String passport) {
    passengerRepository.delete(passengerRepository.findAll().stream().filter(p -> p.getPassport().equals(passport)).findFirst().orElseThrow());
              return "You have deleted a passenger ";
    }

//    {
//        "passport": "s2134",
//            "surname": "Noris",
//            "name": "Chak",
//            "birthdate": null
//    }
//    @GetMapping("/passenger/getbypassport/")
//    public Optional<RequestPassengerDto> getbypassport(@RequestParam String passport) {
//return passengerService.getPassengerByPassport(passport);
//    }

    @GetMapping("/passenger/getbypassport/")
    public Optional<PassengerDto> getbypassport(@RequestParam String passport) {

        Passenger passenger = passengerService.getPassengerByPassport(passport);
        return Optional.ofNullable(modelMapper.map(passenger, PassengerDto.class));
    }
}


