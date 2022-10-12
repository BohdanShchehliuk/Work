package airport.service.impl;

import airport.Main;
import airport.entity.Flight;
import airport.entity.Ticket;
import airport.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Main.class)
class TicketServiceImplTest {

    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    FlightServiceImpl flightService;

    @Test
    void getAllFreeTickets() throws UserNotFoundException {
        Flight flight = flightService.getAll().get(0);
        int flightId = flight.getId();
        List<Ticket> ticketList = null;
        List<Ticket> respond = null;
        try {
            ticketList = ticketService.getAll().stream().filter(ticket -> ticket.getFlightId().getId() == flightId
                    && ticket.getTicketStaus() == 0).collect(Collectors.toList());
            if (ticketList.isEmpty()) {
                ticketList = null;
            }
            respond = ticketService.getAllFreeTickets(flight.getFlightNumb());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        assertEquals(ticketList, respond);
    }

    @Test
    void findTicketsByFlightNumb() throws UserNotFoundException {
        Flight flight = flightService.getAll().stream().findAny().get();
        List<Ticket> respond = ticketService.findTicketsByFlightNumb(flight.getFlightNumb());
        List<Ticket> ticketList = ticketService.getAll().stream().filter(ticket -> ticket.getFlightId().getFlightNumb()
                == flight.getFlightNumb()).collect(Collectors.toList());
        assertEquals(ticketList, respond);
    }
}