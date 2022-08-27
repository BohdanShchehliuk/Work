package airport.service.impl;

import airport.Main;
import airport.entity.Flight;
import airport.entity.Passenger;
import airport.entity.Ticket;
import airport.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Main.class)
class PassengerServiceImplTest {

    @Autowired
    PassengerServiceImpl passengerService;
    @Autowired
    FlightServiceImpl flightService;
    @Autowired
    TicketServiceImpl ticketService;

    @Test
    void delete() throws UserNotFoundException {
        String respond = passengerService.delete("SO1234");
        assertEquals("Passenger successfully deleted", respond);
    }


    @Test
    void getPassengerByPassport() throws UserNotFoundException {
        Passenger passenger = passengerService.getAll().get(0);
        String passport = passenger.getPassport();
        Passenger respond = passengerService.getPassengerByPassport(passport);
        assertEquals(passenger, respond);
    }

    @Test
    void getPassengerByFlightNumb() throws UserNotFoundException {
        Flight flight = flightService.getAll().get(0);
        List<Ticket> ticketList = ticketService.getAll().stream().filter(ticket -> ticket.getFlightId().getId() == flight.getId())
                .collect(Collectors.toList());
        List<Passenger> passengerList = passengerService.getPassengerByFlightNumb(flight.getFlightNumb());
        Passenger passenger;
        for (int i = 0; i < ticketList.size(); i++) {
            passenger = ticketList.get(i).getPassenger();
            passengerList.set(i, passenger);
        }
       List<Passenger> respondList = passengerService.getPassengerByFlightNumb(flight.getFlightNumb());
        assertEquals(passengerList, respondList);
    }
}