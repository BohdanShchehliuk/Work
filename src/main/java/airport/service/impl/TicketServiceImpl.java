package airport.service.impl;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.entity.*;
import airport.exception.CustomException;
import airport.exception.UserAlreadyExistException;
import airport.exception.UserNotFoundException;
import airport.repository.FlightRepository;
import airport.repository.TicketRepository;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
@AllArgsConstructor
@NoArgsConstructor
public class TicketServiceImpl implements TicketService {
    private ModelMapper modelMapper;
    @Autowired
    public TicketRepository ticketRepository;
    @Autowired
    public FlightRepository flightRepository;

    @Override
    public Ticket addTicket(Ticket ticket) throws UserAlreadyExistException {
        log.info("Service / Ticket addTicket(Ticket ticket)/ started work");
            Optional <List <Ticket>> list = Optional.ofNullable(ticketRepository.findTicketsByFlightNumb(ticket.getNumber()));
       if (!list.isEmpty())
            throw new UserAlreadyExistException(ticket.getId(), "Ticket already exists");
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> addTicketsForFlight(Flight flight) {
        log.info("Service / List<Ticket> addTicketsForFlight(Flight flight)/ started work");

        Aircraft aircraft = flight.getAircraft();
        AircraftTypes aircraftTypes = aircraft.getAircraftTypes();
        List<Ticket> ticketList = IntStream.range(1, aircraftTypes.getCapacity())
                .mapToObj(seat -> Ticket.builder()
                        .ticketStaus(TICKET_STATUS_NOT_SOLD)
                        .number(flight.hashCode() + seat)
                        .seat(seat)
                        .flightId(flight)
                        .build())
                .collect(Collectors.toList());
        if (ticketList.isEmpty()) throw new CustomException("tickets is not added");
        ticketRepository.saveAll(ticketList);
        return ticketList;
    }

    ;

    @Override
    public Ticket get(int id) throws UserNotFoundException {
        log.info("Service / List<Ticket> addTicketsForFlight(Flight flight)/ started work");
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("Ticket with id: " + id + "does not exist"));
        return ticket;
    }

    @Override
    public List<Ticket> getAllFreeTickets(int flightId) throws UserNotFoundException {
        log.info("Service / List<Ticket> getAllFreeTickets/ started work");

        List<Ticket> list = ticketRepository.findAll().stream().filter(ticket -> (ticket.getTicketStaus() == TICKET_STATUS_NOT_SOLD &&
                        ticket.getFlightId().getId() == flightId))
                .collect(Collectors.toList());
        if (list.isEmpty()) throw new UserNotFoundException("There are no fre tickets");
        return list;
    }

    @Override
    public Ticket getFirstNonSoldFomFlight(int flightId) throws UserNotFoundException {
        log.info("Service / Ticket getFirstNonSoldFomFlight/ started work");
        return getAllFreeTickets(flightId).stream().findFirst().get();
    }

    @Override
    public TicketDto byTicket(PassengerDto passengerDto, int flightId) throws UserNotFoundException {
        log.info("Service / TicketDto byTicket / started work");
      Optional < Flight> flight = (flightRepository.findById(flightId));
    //       Optional<Flight> flight = Optional.ofNullable(flightRepository.findFlightByFlightNumb(flight_numb));
             if(flight.isEmpty())
            throw new CustomException("There is no such flight");
        Ticket ticket = getFirstNonSoldFomFlight(flightId);
        modelMapper = new ModelMapper();
        Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
        ticket.setPassenger(modelMapper.map(passengerDto, Passenger.class));
        ticket.setTicketStaus(TICKET_STATUS_SOLD);
        ticketRepository.saveAndFlush(ticket);
        TicketDto ticketDto = new TicketDto();
        return modelMapper.map(ticket, TicketDto.class);
    }

    @Override
    public List<Ticket> findTicketsByFlightNumb(int flightNumb) throws UserNotFoundException {
        log.info("Service / List<Ticket> findTicketsByFlightNumb / started work");
        List<Ticket> list = ticketRepository.findTicketsByFlightNumb(flightNumb);
        if (list.isEmpty()) throw new UserNotFoundException("There are no tickets in flightNumb " + flightNumb);
        return list;
    }
}
