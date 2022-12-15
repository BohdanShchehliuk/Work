package airport.controller;


import airport.dto.FlightDto;
import airport.entity.Aircraft;
import airport.entity.AircraftTypes;
import airport.entity.Airline;
import airport.entity.Flight;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.service.impl.FlightServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FlightController  {

    final private ModelMapper mapToEntity;
    final private ModelMapper mapToDTO;
    final private FlightServiceImpl flightService;
    static final String ANSI_RED = "\u001B[31m";

    @PostMapping("/flight/create/")
    public String saveFlight(@RequestBody FlightDto flightDto) throws UserAlreadyExistException {
        log.info("Controller /flight/create/ started work");
        flightService.addFlight(mapToEntity.map(flightDto, Flight.class));
        return "You add a new flight ";
    }

    @GetMapping("/flight/data/between/")

    private List<Flight> getAllFomDataAtoDataB(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startData,
                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishData) throws UserNotFoundException {
        log.info("Controller /flight/data/between/ started work");
        LocalDateTime start = startData.atStartOfDay();
        LocalDateTime finish = finishData.atStartOfDay();
        return flightService.getAllFlightsFromStartDataToFinishData(start, finish);
    }

    @GetMapping("/flight/getAllFlights/")
    private List<Flight> getAllFlights() throws UserNotFoundException {
        log.info("Controller /flight/getAllFlights/ started work");
        return flightService.getAll();
    }

    @GetMapping("/flight/getInfoAboutFlightByFlightNumb/")
    public FlightDto getByNumber(@RequestParam int flightNumb) throws Exception {
        log.info("Controller /flight/getInfoAboutFlightByFlightNumb/ started work");
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

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String get(ModelMap model) {
        model.addAttribute("message", "Hello, World!");
        return "greeting";
    }
}


