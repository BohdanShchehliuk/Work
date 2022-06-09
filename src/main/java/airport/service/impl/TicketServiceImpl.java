package airport.service.impl;

import airport.dao.impl.TicketDaoImpl;
import airport.dto.FlightDto;
import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.entity.*;
import airport.repository.TicketRepository;
import airport.repository.impl.FlightRepositoryImpl;
import airport.repository.impl.TicketRepositoryImpl;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TicketServiceImpl implements TicketService {
    private ModelMapper modelMapper;
    TicketRepository ticketRepository = new TicketRepositoryImpl();

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.add(ticket);
    }

    @Override
    public List<Ticket> addTicketsForFlight(Flight flight) {
        Aircraft aircraft = flight.getAircraft();
        AircraftTypes aircraftTypes = aircraft.getAircraftTypes();
        List<Ticket> ticketList = IntStream.range(1, aircraftTypes.getCapacity())
                .mapToObj(seat -> Ticket.builder().ticketStaus(TICKET_STATUS_NOT_SOLD).number(flight.hashCode() + seat).seat(seat).flightId(flight.getId()).build()).collect(Collectors.toList());

        TicketDaoImpl ticketDao = new TicketDaoImpl();
//ticketList.stream().forEach(ticket -> ticketDao.add(ticket));
        ticketDao.addAll(ticketList);

        //    ticketRepository.saveAndFlush(ticketList.get(1));

        return ticketList;
    }

    @Override
    public Ticket get(int id) {
        TicketRepository ticketRepository = new TicketRepositoryImpl();
        return ticketRepository.get(id);
    }

    @Override
    public List<Ticket> getAllFreeTickets(int flightId) {
        return ticketRepository.getAll().stream().filter(ticket -> (ticket.getTicketStaus() == TICKET_STATUS_NOT_SOLD && ticket.getFlightId() == flightId)).collect(Collectors.toList());
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
        ticket.setRoutes(new FlightRepositoryImpl().get(flightId).getRoutes());
        System.out.println("ticket = "+ ticket);
        System.out.println(passenger.getTickets());
        ticketRepository.update(ticket);
        TicketDto ticketDto = new TicketDto();
        return modelMapper.map(ticket, TicketDto.class);
    }
}
