package airport.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import airport.service.FlightService;

@RestController
@AllArgsConstructor
public class FlightController {

    private FlightService flightService;

    @GetMapping()
    public String hello() {
        return "How are you doing:  " + flightService.getAll().toString();
    }
}
