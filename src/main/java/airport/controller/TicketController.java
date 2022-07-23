package airport.controller;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class TicketController {
    private TicketService ticketService;

    @GetMapping("/tickets/by/flight")
    public String getAllByFlightNumb(@RequestParam int flightNumb) {
        return ticketService.findTicketsByFlightNumb(flightNumb).toString();
    }

    @PostMapping("/ticket/bay/")
    public String byTicket(@RequestBody PassengerDto passengerDto, @RequestParam int flightId) {
        TicketDto ticketDto = ticketService.byTicket(passengerDto, flightId);
        return "Passenger" + passengerDto + "by a new ticket " + ticketDto;
    }
}


