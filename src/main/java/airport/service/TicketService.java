package airport.service;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.enam.TicketStatus;
import airport.entity.Flight;
import airport.entity.Ticket;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;

import java.util.List;

public interface TicketService {

    Ticket addTicket(Ticket ticket) throws UserAlreadyExistException;

    List<Ticket> addTicketsForFlight(Flight flight);

    Ticket get(int id) throws UserNotFoundException;

    List<Ticket> getAllFreeTickets(int flightId) throws UserNotFoundException;

    Ticket getFirstNonSoldFomFlight(int flightId) throws UserNotFoundException;

    TicketDto byTicket(PassengerDto passengerDto, int flightId) throws UserNotFoundException;

    List<Ticket> findTicketsByFlightNumb(int flightNumb) throws UserNotFoundException;
    List <Ticket> getAll() throws UserNotFoundException;

}
