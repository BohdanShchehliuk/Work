package airport.utils;

import airport.repository.AircraftRepository;
import airport.service.FlightService;
import airport.service.PassengerService;
import airport.service.impl.FlightServiceImpl;
import airport.service.impl.PassengerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Bean
    public FlightService flightService() {
        return new FlightServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PassengerService passengerService() {
        return new PassengerServiceImpl();
    }
}
