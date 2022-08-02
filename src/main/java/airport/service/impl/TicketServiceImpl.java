package airport.service.impl;

import airport.dto.PassengerDto;
import airport.dto.TicketDto;
import airport.entity.*;
import airport.exception.CustomException;
import airport.repository.FlightRepository;
import airport.repository.TicketRepository;
import airport.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TicketServiceImpl implements TicketService {
    private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);
    public static final String ANSI_RED = "\u001B[31m";
    private ModelMapper modelMapper;
    @Autowired
    public TicketRepository ticketRepository;
    public FlightRepository flightRepository;

    @Override
    public Ticket addTicket(Ticket ticket) {
        LOG.debug("Service / Ticket addTicket(Ticket ticket)/ started work");
        try {
            return ticketRepository.save(ticket);
        } catch (Exception exception) {
            LOG.error(ANSI_RED + " ticketRepository.save(ticket)  does not answer");
            throw new CustomException(" ticketRepository.save(ticket)", " is not correct");
        }

    }

    @Override
    public List<Ticket> addTicketsForFlight(Flight flight) {
        LOG.debug("Service / List<Ticket> addTicketsForFlight(Flight flight)/ started work");
        try {
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
        } catch (Exception exception) {
            LOG.error(ANSI_RED + " ticketRepository.saveAll(ticketList)  does not answer");
            throw new CustomException("  ticketRepository.saveAll(ticketList)", " is not correct");
        }
    }

    @Override
    public Ticket get(int id) {
        LOG.debug("Service / List<Ticket> addTicketsForFlight(Flight flight)/ started work");
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Ticket> getAllFreeTickets(int flightId) {
        LOG.debug("Service / List<Ticket> getAllFreeTickets/ started work");
        try {

            return ticketRepository.findAll().stream().filter(ticket -> (ticket.getTicketStaus() == TICKET_STATUS_NOT_SOLD &&
                            ticket.getFlightId().getId() == flightId))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            LOG.error(ANSI_RED + "List<Ticket> getAllFreeTickets  does not answer");
            throw new CustomException("  List<Ticket> getAllFreeTickets", " is not correct");
        }
    }

        @Override
        public Ticket getFirstNonSoldFomFlight ( int flightId) {
            LOG.debug("Service / Ticket getFirstNonSoldFomFlight/ started work");
            try {
                return getAllFreeTickets(flightId).stream().findFirst().get();
            } catch (Exception exception) {
                LOG.error(ANSI_RED + "Ticket getFirstNonSoldFomFlight does not answer");
                throw new CustomException("  Ticket getFirstNonSoldFomFlight", " is not correct");
            }
        }

        @Override
        public TicketDto byTicket (PassengerDto passengerDto,int flightId) {
            LOG.debug("Service / TicketDto byTicket / started work");
            try {
                Ticket ticket = getFirstNonSoldFomFlight(flightId);
                modelMapper = new ModelMapper();
                Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
                ticket.setPassenger(modelMapper.map(passengerDto, Passenger.class));
                ticket.setTicketStaus(TICKET_STATUS_SOLD);
                ticketRepository.saveAndFlush(ticket);
                TicketDto ticketDto = new TicketDto();
                return modelMapper.map(ticket, TicketDto.class);
            } catch (Exception exception) {
                LOG.error(ANSI_RED + "TicketDto byTicket does not answer");
                throw new CustomException("  TicketDto byTicket", " is not correct");
            }
        }

        @Override
        public List<Ticket> findTicketsByFlightNumb ( int flightNumb){
            LOG.debug("Service / List<Ticket> findTicketsByFlightNumb / started work");
            try {
                return ticketRepository.findTicketsByFlightNumb(flightNumb);
            }catch (Exception exception) {
                LOG.error(ANSI_RED + "List<Ticket> findTicketsByFlightNumb does not answer");
                throw new CustomException("  List<Ticket> findTicketsByFlightNumb", " is not correct");
            }
        }
    }
