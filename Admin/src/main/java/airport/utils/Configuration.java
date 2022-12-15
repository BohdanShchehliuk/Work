package airport.utils;


import airport.service.FlightService;
import airport.service.PassengerService;
import airport.service.PersonalService;
import airport.service.TicketService;
import airport.service.impl.FlightServiceImpl;
import airport.service.impl.PassengerServiceImpl;
import airport.service.impl.PersonalServiceImpl;
import airport.service.impl.TicketServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public PersonalService personalService() {

        return new PersonalServiceImpl();
    }

    @Bean
    public FlightService flightService() {

        return new FlightServiceImpl();
    }

    @Bean
    public TicketService ticketService() {
        return new TicketServiceImpl();
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
