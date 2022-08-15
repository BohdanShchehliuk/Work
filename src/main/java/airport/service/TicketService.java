package airport.service;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.entity.Flight;
import airport.entity.Ticket;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;

import java.util.List;

public interface TicketService {
    int TICKET_STATUS_NOT_SOLD = 0;
    int TICKET_STATUS_SOLD = 1;
    int TICKET_STATUS_BOARDED = 2;
    int TICKET_STATUS_FINISHED = 3;

    Ticket addTicket(Ticket ticket) throws UserAlreadyExistException;

    List<Ticket> addTicketsForFlight(Flight flight);

    Ticket get(int id) throws UserNotFoundException;

    List<Ticket> getAllFreeTickets(int flightId) throws UserNotFoundException;

    Ticket getFirstNonSoldFomFlight(int flightId) throws UserNotFoundException;

    TicketDto byTicket(PassengerDto passengerDto, int flightId) throws UserNotFoundException;

    List<Ticket> findTicketsByFlightNumb(int flightNumb) throws UserNotFoundException;

}
