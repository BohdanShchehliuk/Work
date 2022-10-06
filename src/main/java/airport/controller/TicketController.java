package airport.controller;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.exception.UserNotFoundException;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;
    public static final String ANSI_RED = "\u001B[31m";

    @GetMapping("/tickets/by/flight/")
    public String getAllByFlightNumb(@RequestParam int flightNumb) throws UserNotFoundException {
        log.info("Controller /tickets/by/flight started work");
        return ticketService.findTicketsByFlightNumb(flightNumb).toString();
    }

    @PostMapping("/ticket/bay/")
    public String byTicket(@RequestBody PassengerDto passengerDto, @RequestParam int flightId) throws UserNotFoundException {
        log.info("Controller /ticket/bay/ started work");
        TicketDto ticketDto = ticketService.byTicket(passengerDto, flightId);
        return "Passenger" + passengerDto + "by a new ticket   " + ticketDto;
    }
}


