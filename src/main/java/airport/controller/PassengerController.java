package airport.controller;

import airport.dto.PassengerDto;
import airport.entity.Passenger;
import airport.exception.CustomException;
import airport.service.PassengerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class PassengerController {
    private PassengerService passengerService;
    private ModelMapper mapToEntity;
    private ModelMapper mapToDTO;
    private static final Logger LOG = LoggerFactory.getLogger(PassengerController.class);
    public static final String ANSI_RED = "\u001B[31m";

    @PostMapping("/passenger/post/")
    public String savePassenger(@RequestBody PassengerDto passenger) {
        LOG.info("Service /passenger/post/ started work");
        try {
            passengerService.addPassenger(mapToEntity.map(passenger, Passenger.class));
            return "You add a new passenger from Front End";
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /passenger/post/ does not answer");
            throw new CustomException("/passenger/post/", " is not correct");
        }
    }

    @GetMapping("/passenger/create/")
    public String create(String passengerName, String passengerSurname, String passengerPassport) {
        LOG.info("Service /passenger/create/ started work");
        try {
            PassengerDto passengerDto = PassengerDto.builder()
                    .name(passengerName)
                    .surname(passengerSurname)
                    .passport(passengerPassport)
                    .build();
            return savePassenger(passengerDto);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /passenger/create/ does not answer");
            throw new CustomException("/passenger/create/", " is not correct");
        }
    }

    @PostMapping("/passenger/delete/")
    public String deletePassenger(@RequestParam String passport) throws Exception {
        LOG.info("Service /passenger/delete/ started work");
        try {
            if (passengerService.delete(passport).equals("success"))
                return "You have deleted a passenger ";
            return "There is no such passenger";
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /passenger/delete/ does not answer");
            throw new CustomException("/passenger/delete/", " is not correct");
        }
    }

    @GetMapping("/passenger/getbypassport/")
    public Optional<PassengerDto> getByPassport(@RequestParam String passport) {
        LOG.info("Service /passenger/getbypassport/ started work");
        try {
            Passenger passenger = passengerService.getPassengerByPassport(passport);
            return Optional.ofNullable(mapToDTO.map(passenger, PassengerDto.class));
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /passenger/getbypassport/ does not answer");
            throw new CustomException("/passenger/getbypassport/", " is not correct");
        }
    }

    @GetMapping("/passenger/allpassengerbyflightnumber/")
    public String getPassengerByFlightNumb(@RequestParam int flightNumb) {
        LOG.info("Service /passenger/allpassengerbyflightnumber/ started work");
        try {
            List<Passenger> list = passengerService.getPassengerByFlightNumb(flightNumb);
            return list.toString();
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /passenger/allpassengerbyflightnumber/ does not answer");
            throw new CustomException("/passenger/allpassengerbyflightnumber/", " is not correct");
        }
    }
}


