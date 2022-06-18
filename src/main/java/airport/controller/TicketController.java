package airport.controller;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.entity.Ticket;
import airport.repository.TicketRepository;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TicketController {
    TicketRepository ticketRepository;
    public TicketService ticketService;
    ModelMapper modelMapper;

    @PostMapping("/ticket/bay/")
    public String byTicket(@RequestBody PassengerDto passengerDto, @RequestParam int flightId) {

TicketDto ticketDto = ticketService.byTicket(passengerDto, flightId);

     return "Passenger"+passengerDto+ "by a new ticket "+ticketDto;
    }

//
//    @RequestBody
//    {
//        "passport": "s2134",
//            "surname": "Noris",
//            "name": "Chak",
//            "birthdate": null
//
//    }
//@RequestParam
//    flightId = 8

    }

