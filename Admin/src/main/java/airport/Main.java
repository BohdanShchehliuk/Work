package airport;

import airport.exception.UserNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Main {
      public static void main(String[] args) throws UserNotFoundException {
        SpringApplication.run(Main.class, args);
    }
}
