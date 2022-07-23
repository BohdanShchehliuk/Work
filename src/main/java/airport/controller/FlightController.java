package airport.controller;


import airport.dto.FlightDto;
import airport.entity.*;
import airport.service.impl.FlightServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    @PostMapping("/flight/post/")
    public String saveFlight(@RequestBody FlightDto flightDto) {
        flightService.addFlight(mapToEntity.map(flightDto, Flight.class));
        return "You add a new flight ";
    }

    @GetMapping("/flight/data/between/")

    private String getAllFomDataAtoDataB(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startData,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishData) {
        LocalDateTime start = startData.atStartOfDay();
        LocalDateTime finish = finishData.atStartOfDay();
        return flightService.getAllFlightsFromStartDataToFinishData(start, finish).toString();
    }

    @GetMapping("/flight/get/tickets/")
    public FlightDto getByNumber(@RequestParam int flightNumb) {
        return mapToDTO.map(flightService.findFlightByFlightNumb(flightNumb), FlightDto.class);
    }

    @GetMapping("/flight/create")
    public FlightDto create() {
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


