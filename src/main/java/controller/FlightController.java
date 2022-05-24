package controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FlightService;

@RestController
@AllArgsConstructor
public class FlightController {

    private FlightService flightService;

    @GetMapping("LLL")
    public String hello() {
        return flightService.getAll().toString();
    }
}
