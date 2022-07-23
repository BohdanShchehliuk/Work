package airport.service.impl;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.entity.*;
import airport.repository.FlightRepository;
import airport.repository.TicketRepository;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TicketServiceImpl implements TicketService {
    private ModelMapper modelMapper;
    @Autowired
    public TicketRepository ticketRepository;
    public FlightRepository flightRepository;

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> addTicketsForFlight(Flight flight) {
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
        ticketRepository.saveAll(ticketList);
        return ticketList;
    }

    @Override
    public Ticket get(int id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Ticket> getAllFreeTickets(int flightId) {
        System.out.println(ticketRepository.findAll());
        return ticketRepository.findAll().stream().filter(ticket -> (ticket.getTicketStaus() == TICKET_STATUS_NOT_SOLD &&
                        ticket.getFlightId().getId() == flightId))
                .collect(Collectors.toList());
    }

    @Override
    public Ticket getFirstNonSoldFomFlight(int flightId) {
        return getAllFreeTickets(flightId).stream().findFirst().get();
    }

    @Override
    public TicketDto byTicket(PassengerDto passengerDto, int flightId) {
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
    public List<Ticket> findTicketsByFlightNumb(int flightNumb) {
        return ticketRepository.findTicketsByFlightNumb(flightNumb);
    }
}
