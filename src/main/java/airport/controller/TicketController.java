package airport.controller;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.exception.CustomException;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class TicketController {
    private TicketService ticketService;
    private static final Logger LOG = LoggerFactory.getLogger(PassengerController.class);
    public static final String ANSI_RED = "\u001B[31m";

    @GetMapping("/tickets/by/flight")
    public String getAllByFlightNumb(@RequestParam int flightNumb) {
        LOG.info("Service /tickets/by/flight started work");
        try {
            return ticketService.findTicketsByFlightNumb(flightNumb).toString();
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /tickets/by/flight/ does not answer");
            throw new CustomException("/tickets/by/flight/", " is not correct");
        }
    }

    @PostMapping("/ticket/bay/")
    public String byTicket(@RequestBody PassengerDto passengerDto, @RequestParam int flightId) {
        LOG.info("Service /ticket/bay/ started work");
        try {
            TicketDto ticketDto = ticketService.byTicket(passengerDto, flightId);
            return "Passenger" + passengerDto + "by a new ticket   " + ticketDto;
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "Service /ticket/bay/ does not answer");
            throw new CustomException("/ticket/bay/", " is not correct");
        }
    }
}


