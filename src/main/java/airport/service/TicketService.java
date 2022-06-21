package airport.service;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.entity.Flight;
import airport.entity.Ticket;

import java.util.List;

public interface TicketService {
    int TICKET_STATUS_NOT_SOLD = 0;
    int TICKET_STATUS_SOLD = 1;
    int TICKET_STATUS_BOARDED = 2;
    int TICKET_STATUS_FINISHED = 3;

    Ticket addTicket(Ticket ticket);

    List<Ticket> addTicketsForFlight(Flight flight);

    Ticket get(int id);

    List<Ticket> getAllFreeTickets(int flightId);

    Ticket getFirstNonSoldFomFlight(int flightId);

    TicketDto byTicket(PassengerDto passengerDto, int flightId);

}
