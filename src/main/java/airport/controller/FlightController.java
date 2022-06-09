package airport.controller;


import airport.dto.FlightDto;
import airport.entity.Aircraft;
import airport.entity.AircraftTypes;
import airport.entity.Airline;
import airport.entity.Flight;
import airport.repository.AircraftRepository;
import airport.repository.FlightRepository;
import airport.repository.impl.AircraftRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import airport.service.FlightService;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@AllArgsConstructor
public class FlightController {
    FlightRepository flightRepository;
    ModelMapper modelMapper;
    public FlightService flightService;

    @PostMapping("/flight/post/")
    public String saveFlight(@RequestBody FlightDto flightDto) {
        System.out.println("flightDTO = " + flightDto);
        flightService.addFlight(modelMapper.map(flightDto, Flight.class));
        return "You add a new flight ";
    }
    @GetMapping("/flight/data/between/")
    private String getAllFomDataAtoDataB(@RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate startData, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishData){
        System.out.println(flightRepository.getAll());
        return flightService.getAllFomDataAtoDataB(startData, finishData).toString();
    }


    @GetMapping("/flight/get")
    public FlightDto get() {
        AircraftRepository aircraftRepository = new AircraftRepositoryImpl();
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
