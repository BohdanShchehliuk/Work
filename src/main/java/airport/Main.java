package airport;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.modelmapper.ModelMapper;

@Builder
@SpringBootApplication
@Data
public class Main {
    private ModelMapper modelMapper;
    public static void main(String[] args) {

//              Passenger passenger = Passenger.builder()
//                .passport("AA1222")
//                .surname("Petrenko")
//                .name("Ivan")
//                .tickets(ticketDao.add())??
//                 .build();
//
//        passengerDao.add(passenger);
//        passenger.setBirthdate(new Date());
//        passengerDao.update(passenger);
        //       System.out.println(passengerDao.get(1));
//        passengerDao.delete(passenger);
//        System.out.println(passengerDao.getAll());
//        System.out.println(passengerDao.get(5));
//        System.out.println(salaryDao.getAll());

//        Ticket ticket =  Ticket.builder()
//               .seat(333)
//                .build();
//       System.out.println(ticket);
//
//        ticketDao.add(ticket);
//        System.out.println(ticketDao.getAll());
//        ticket.setSeat(999);
//        ticketDao.update(ticket);
//        System.out.println(ticketDao.getAll());
//        ticketDao.delete(ticket);
//        System.out.println(ticketDao.getAll());
//        System.out.println(ticketDao.get(1));
//
//        System.out.println(aircraftDao.get(3).getAirline());

        //System.out.println((aircraftDao.get(3).getAirline()) +"  ;   "+ airlineDao.get(2).getAircrafts());
//        System.out.println(passengerDao.get(1).getSurname() + " has tickets: "+ passengerDao.get(1).getTickets());
//       System.out.println(ticketDao.get(1));
//       System.out.println(aircraftDao.get(1).getAircraftTypes());
        //System.out.println(passengerDao.getAll());
        // passengerDao.get(1);
        //System.out.println(flightDao.get(1).getAircraft().getAircraftTypes().getCapacity());
        // System.out.println(gateDao.get(1));
        //   System.out.println(passengerDao.get(1));
        //   System.out.println(personalDao.get(1).getGate().getTerminal().getName());
//System.out.println(personalInfoDao.get(1).getPersonal().getPersonalInfo().isMarried());
//        System.out.println(salaryDao.get(2));
//        System.out.println(ticketDao.get(3));
//        System.out.println(passengerDao.getByIdWithTickets(2));
//        //     System.out.println(passengerDao.get(1).getSurname()); // - видає помилку
//        AircraftRepositoryImpl aircraftRepository = new AircraftRepositoryImpl();
//        aircraftRepository.getAll();
//        SalaryRepositoryImpl salaryRepository = new SalaryRepositoryImpl();
//        System.out.println(salaryRepository.getAll());
//        TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();
//        System.out.println(ticketRepository.getAll());
//        PassengerRepositoryImpl passengerRepository = new PassengerRepositoryImpl();
//        passengerRepository.get(1);

        SpringApplication.run(Main.class, args);


//        PassengerDto passengerDto;
//
//        ModelMapper modelMapper = new ModelMapper();
//
//        System.out.println(passengerDao.getPassengerByPassport("GO1234"));
//        passengerDto = modelMapper.map(passengerDao.getPassengerByPassport("GO1234"), PassengerDto.class);
//
//        TicketService ticketService = new TicketServiceImpl();
//        ticketService.byTicket(passengerDto, 8);

//        Flight flight = Flight.builder()
//                .flightNumb(333333)
//                .flightStatus(0)
//                .aircraft(aircraftDao.get(2))
//                .airline(airlineDao.get(2))
//                .terminal(terminalDao.get(1))
//                .routes(routesDao.get(1))
//                .time(new Date())
//                .build();
//        System.out.println(flight.toString());
//        flightDao.add(flight);
//        TicketService ticketService = new TicketServiceImpl();
//        ticketService.addTicketsForFlight(flight);


    }
}




