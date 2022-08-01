package airport.controller;


import airport.dto.FlightDto;
import airport.entity.*;
import airport.exception.CustomException;
import airport.service.impl.FlightServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class FlightController {
    private ModelMapper mapToEntity;
    private ModelMapper mapToDTO;
    private FlightServiceImpl flightService;
    private static final Logger LOG = LoggerFactory.getLogger(FlightController.class);
    public static final String ANSI_RED = "\u001B[31m";

    @PostMapping("/flight/post/")
    public String saveFlight(@RequestBody FlightDto flightDto) {
        LOG.info("Service /flight/post/ started work");
        try {
            flightService.addFlight(mapToEntity.map(flightDto, Flight.class));
            return "You add a new flight ";
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /flight/post/ does not answer");
            throw new CustomException("/flight/post/", " is not correct");
        }
    }

    @GetMapping("/flight/data/between/")

    private String getAllFomDataAtoDataB(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startData,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishData) {
        LOG.info("Service /flight/data/between/ started work");
        try {
            LocalDateTime start = startData.atStartOfDay();
            LocalDateTime finish = finishData.atStartOfDay();
            return flightService.getAllFlightsFromStartDataToFinishData(start, finish).toString();
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /flight/data/between/ does not answer");
            throw new CustomException("/flight/data/between/", " is not correct");
        }
    }

    @GetMapping("/flight/get/tickets/")
    public FlightDto getByNumber(@RequestParam int flightNumb) {
        LOG.info("Service /flight/get/tickets/ started work");
        try {
            return mapToDTO.map(flightService.findFlightByFlightNumb(flightNumb), FlightDto.class);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /flight/get/tickets/ does not answer");
            throw new CustomException("/flight/get/tickets/", " is not correct");
        }
    }

    @GetMapping("/flight/create/")
    public FlightDto create() {
        LOG.info("Service /flight/create/ started work");
        try {
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
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /flight/create/  does not answer");
            throw new CustomException("/flight/create/", " is not correct");
        }
    }

}


