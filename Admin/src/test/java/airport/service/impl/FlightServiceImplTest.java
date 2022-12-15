package airport.service.impl;

import airport.Main;
import airport.entity.Flight;
import airport.exception.UserNotFoundException;
import airport.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Main.class)
class FlightServiceImplTest {
    @Autowired
    FlightServiceImpl flightService;
    @Autowired
    FlightRepository flightRepository;

    @Test
    void findFlightByFlightNumb() throws UserNotFoundException {
        List<Flight> flightList = flightService.getAll();
        Flight flight = flightList.get(1);
        System.out.println(flight);
        int numb = flight.getFlightNumb();
        assertEquals(flight, flightService.findFlightByFlightNumb(numb).get());
    }

    @Test
    void getAllFlightsFromStartDataToFinishData() throws UserNotFoundException {
        LocalDateTime startData = LocalDateTime.of(2020, 12, 11, 11, 12);
        LocalDateTime finishData = LocalDateTime.of(2022, 12, 11, 11, 12);
        List<Flight> respond = flightService.getAllFlightsFromStartDataToFinishData(startData, finishData);
        System.out.println(respond);
        List<Flight> flightList = flightService
                .getAll().stream().
                filter(flight -> flight.getTime().isAfter(startData) &&
                        flight.getTime().isBefore(finishData))
                .collect(Collectors.toList());
        assertEquals(flightList, respond);
    }
}