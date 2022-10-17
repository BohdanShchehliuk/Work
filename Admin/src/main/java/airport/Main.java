package airport;

import airport.exception.UserNotFoundException;
import airport.service.impl.PassengerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws UserNotFoundException {
        SpringApplication.run(Main.class, args);
    }
}
