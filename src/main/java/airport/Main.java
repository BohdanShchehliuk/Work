package airport;

import airport.exception.UserNotFoundException;
import airport.service.impl.FlightServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws UserNotFoundException {
        SpringApplication.run(Main.class, args);
        FlightServiceImpl flightService = new FlightServiceImpl();
        System.out.println(flightService.findFlightByFlightNumb(11));
    }
}
