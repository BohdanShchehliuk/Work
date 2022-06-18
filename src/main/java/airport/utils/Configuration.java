package airport.utils;

import airport.dao.impl.PassengerDaoImpl;
import airport.entity.Flight;
import airport.repository.AircraftRepository;
import airport.repository.FlightRepository;
import airport.repository.PassengerRepository;
import airport.repository.TicketRepository;
import airport.repository.impl.AircraftRepositoryImpl;
import airport.repository.impl.FlightRepositoryImpl;
import airport.repository.impl.PassengerRepositoryImpl;
import airport.repository.impl.TicketRepositoryImpl;
import airport.service.FlightService;
import airport.service.PassengerService;
import airport.service.impl.FlightServiceImpl;
import airport.service.impl.PassengerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public PassengerRepository passengerRepository() {
        return new PassengerRepositoryImpl();
    }

    @Bean
    public FlightRepository flightRepository() {
        return new FlightRepositoryImpl();
    }
    @Bean
    public TicketRepository ticketRepository() {
        return new TicketRepositoryImpl();
    }

    @Bean
    public FlightService flightService() {
        return new FlightServiceImpl();
    }

    @Bean
    public AircraftRepository aircraftRepository() {
        return new AircraftRepositoryImpl();
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
