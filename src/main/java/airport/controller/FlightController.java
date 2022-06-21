package airport.controller;


import airport.dto.FlightDto;
import airport.entity.Aircraft;
import airport.entity.AircraftTypes;
import airport.entity.Airline;
import airport.entity.Flight;
import airport.repository.FlightRepository;
import airport.service.impl.FlightServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class FlightController {
    @Autowired
    FlightRepository flightRepository;
    ModelMapper modelMapper;
    public FlightServiceImpl flightService;

    @PostMapping("/flight/post/")
    public String saveFlight(@RequestBody FlightDto flightDto) {

        flightService.addFlight(modelMapper.map(flightDto, Flight.class));
        return "You add a new flight ";
    }
    @GetMapping("/flight/data/between/")
    private String getAllFomDataAtoDataB(@RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate startData, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishData){

        return flightService.getAllFomDataAtoDataB(startData, finishData).toString();
    }

@GetMapping ("/flight/get/tickets/")
public String getByNumber(@RequestParam int flightNumb) {
    Flight flight = flightRepository.findFlightByFlightNumb(flightNumb);
    System.out.println(flight.toString());
    return flight.toString();
}
    @GetMapping("/flight/get")
    public FlightDto get() {

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
//    {
//        "flightNumb": 12121,
//            "flightStatus": 1,
//            "time": "2022-06-05T16:13:07.144118",
//            "aircraft": {
//        "id": 0,
//                "serialNumber": 0,
//                "airline": {
//            "id": 0,
//                    "name": null,
//                    "rate": 0,
//                    "aircrafts": null
//        },
//        "aircraftTypes": {
//            "id": 0,
//                    "produser": "Nokia",
//                    "type": null,
//                    "capacity": 300
//        }
//    }
//    }
}
