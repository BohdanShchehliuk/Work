package airport.controller;


import airport.dto.FlightDto;
import airport.entity.*;
import airport.exception.CustomException;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.service.impl.FlightServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RestController
@AllArgsConstructor
public class FlightController {
    private ModelMapper mapToEntity;
    private ModelMapper mapToDTO;
    private FlightServiceImpl flightService;
    public static final String ANSI_RED = "\u001B[31m";

    @PostMapping("/flight/create/")
    public String saveFlight(@RequestBody FlightDto flightDto) throws UserAlreadyExistException {
        log.info("Controller /flight/create/ started work");
        if (flightDto.equals(null)) throw new CustomException("Type flight again");
        flightService.addFlight(mapToEntity.map(flightDto, Flight.class));
        return "You add a new flight ";
    }

    @GetMapping("/flight/data/between/")

    private String getAllFomDataAtoDataB(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startData,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishData) throws UserNotFoundException {
        log.info("Controller /flight/data/between/ started work");
        LocalDateTime start = startData.atStartOfDay();
        LocalDateTime finish = finishData.atStartOfDay();
        return flightService.getAllFlightsFromStartDataToFinishData(start, finish).toString();
    }

    @GetMapping("/flight/get/tickets/")
    public FlightDto getByNumber(@RequestParam int flightNumb) throws Exception {
        log.info("Controller /flight/get/tickets/ started work");
        if (flightNumb <= 0) throw new CustomException("Type flight_number again");
        return mapToDTO.map(flightService.findFlightByFlightNumb(flightNumb), FlightDto.class);
    }

    @GetMapping("/flight/create/")
    public FlightDto create() {
        log.info("Controller /flight/create/ started work");
        return FlightDto.builder()
                .flightNumb(12121)
                .flightStatus(1)
                .time(LocalDateTime.now())
                .aircraft(Aircraft.builder()
                        .aircraftTypes(AircraftTypes.builder()
                                .capacity(300)
                                .produser("Nokia")
                                .build())
                        .airline(Airline.builder()
                                .name("Kentyky")
                                .build())
                        .build())
                .build();
    }
}


